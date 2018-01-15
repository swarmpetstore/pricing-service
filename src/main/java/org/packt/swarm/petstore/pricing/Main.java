package org.packt.swarm.petstore.pricing;

import org.jboss.shrinkwrap.api.Archive;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.keycloak.Secured;

public class Main {

    public static void main(String[] args) throws Exception {

        DatasourcesFraction datasourcesFraction = new DatasourcesFraction()
                //1
                .jdbcDriver("postgres", (d) -> {
                    d.driverClassName("org.postgresql.Driver");
                    d.xaDatasourceClass("org.postgresql.xa.PGXADataSource");
                    d.driverModuleName("org.postgresql.jdbc");
                })
                .dataSource("PricingDS", (ds) -> {
                    ds.driverName("postgres");
                    ds.connectionUrl("jdbc:postgresql://"
                            + System.getenv("POSTGRESQL_HOST")
                            + "/"+  System.getenv("POSTGRESQL_SCHEMA"));
                    ds.userName(System.getenv("POSTGRESQL_USER"));
                    ds.password(System.getenv("POSTGRESQL_PASSWORD"));
                });

        Swarm swarm = new Swarm();
        swarm.fraction(datasourcesFraction);

        swarm.start();

        Archive<?> deployment = swarm.createDefaultDeployment();

        deployment.as(Secured.class);
//                .protect( "/price/*" )
//                .withMethod( "GET" )
//                .withRole( "customer" );

        swarm.deploy(deployment);
    }
}