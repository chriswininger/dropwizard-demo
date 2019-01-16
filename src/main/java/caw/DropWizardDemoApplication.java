package caw;

import caw.db.AuthorDAO;
import caw.db.BookDao;
import caw.db.ChapterDAO;
import caw.resources.AppInfoResource;
import caw.resources.AuthorResource;
import caw.resources.BookResource;
import caw.resources.ChapterResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.migrations.MigrationsBundle;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;
import org.jdbi.v3.core.Jdbi;

@SwaggerDefinition (
    info = @Info(
        title = "JSUG Library Demo Application API",
        version = "0.0.01",
        description = "A demonstration api for getting lists of books and information about them",
        license = @License(name = "MIT", url = "https://github.com/chriswininger/dropwizard-demo"),
        contact = @Contact(url = "https://github.com/chriswininger/dropwizard-demo", name = "Chris Wininger")
    ),
    host = "localhost:8080",
    basePath = "/"
)

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
        final BookDao bookDao = jdbi.onDemand(BookDao.class);
        final ChapterDAO chapterDAO = jdbi.onDemand(ChapterDAO.class);

        // register resource classes
        environment.jersey().register(new AuthorResource(authorDAO));
        environment.jersey().register(new BookResource(bookDao));
        environment.jersey().register(new ChapterResource(chapterDAO));

        environment.jersey().register(new AppInfoResource(configuration.getEnvironment()));
    }

}
