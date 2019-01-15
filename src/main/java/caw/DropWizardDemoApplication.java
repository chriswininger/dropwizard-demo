package caw;

import caw.db.AuthorDAO;
import caw.resources.AppInfoResource;
import caw.resources.AuthorResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.migrations.MigrationsBundle;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.jdbi.v3.core.Jdbi;

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

        bootstrap.addBundle(new SwaggerBundle<DropWizardDemoConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(DropWizardDemoConfiguration configuration) {
                return configuration.swaggerBundleConfiguration;
            }
        });
    }

    @Override
    public void run(final DropWizardDemoConfiguration configuration,
                    final Environment environment
    ) {
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");

        // setup daos to provide to resources
        final AuthorDAO authorDAO = jdbi.onDemand(AuthorDAO.class);

        // register resource classes
        environment.jersey().register(new AuthorResource(authorDAO));

        environment.jersey().register(new AppInfoResource(configuration.getEnvironment()));
    }

}
