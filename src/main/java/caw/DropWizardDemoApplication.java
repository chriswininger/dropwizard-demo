package caw;

import caw.resources.AppInfoResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.migrations.MigrationsBundle;

public class DropWizardDemoApplication extends Application<DropWizardDemoConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropWizardDemoApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropWizardDemo";
    }

    @Override
    public void initialize(final Bootstrap<DropWizardDemoConfiguration> bootstrap) {
       bootstrap.addBundle(new MigrationsBundle<DropWizardDemoConfiguration>() {
           @Override
           public DataSourceFactory getDataSourceFactory(DropWizardDemoConfiguration configuration) {
               return configuration.getDataSourceFactory();
           }
       });
    }

    @Override
    public void run(final DropWizardDemoConfiguration configuration,
                    final Environment environment
    ) throws ClassNotFoundException {
        // register resources
        environment.jersey().register(new AppInfoResource(configuration.getEnvironment()));
    }

}
