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

Set `STRIPE_KEY` environment variable to point to your stripe test secret api key.

Start the spring boot app through intelliJ or otherwise

## Run the react app

Set `REACT_APP_STRIPE_KEY` to point to your stripe test publishable key.

```
cd react/salon-ui
yarn start
```
