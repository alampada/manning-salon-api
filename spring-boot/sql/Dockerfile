FROM postgres

ENV POSTGRES_USER salon
ENV POSTGRES_PASSWORD salon
ENV POSTGRES_DB salon

COPY pg-updated.sql /docker-entrypoint-initdb.d/
