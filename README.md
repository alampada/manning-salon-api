# Salon project

Implementation of the manning live project.

## Running spring boot app

Build the postgres docker container that includes test data:

```
cd salon-project/spring-boot
./docker-build.sh
```

Start the container:
```
docker run --rm -d salon-postgres
```

Do a docker inspect to find out the ip of the container and update `application.properties` if needed.

Set `STRIPE_KEY` environment variable to point to your stripe test api key.

Start the spring boot app through intelliJ or otherwise

## Run the react app

```
cd react/salon-ui
yarn start
```
