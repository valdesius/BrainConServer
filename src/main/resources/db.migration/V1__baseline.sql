CREATE TABLE "flyway_schema_history" (
                                         "installed_rank" INT NOT NULL,
                                         "version" VARCHAR(50),
                                         "description" VARCHAR(200),
                                         "type" VARCHAR(20) NOT NULL,
                                         "script" VARCHAR(1000) NOT NULL,
                                         "checksum" INT,
                                         "installed_by" VARCHAR(100) NOT NULL,
                                         "installed_on" TIMESTAMP DEFAULT current_timestamp NOT NULL,
                                         "execution_time" INT NOT NULL,
                                         "success" BOOL NOT NULL
);