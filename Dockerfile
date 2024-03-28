ARG RUNTIME_IMAGE=openjdk:17
ARG APP_HOME=/app

FROM $RUNTIME_IMAGE AS builder
COPY mat-chat-app/build/libs/mat-chat-*.jar /temp/app.jar
RUN java -Djarmode=layertools -jar /temp/app.jar extract --destination /extract/

FROM $RUNTIME_IMAGE
ARG APP_HOME=/app
WORKDIR $APP_HOME

COPY --from=builder extract/spring-boot-loader/ $APP_HOME/
COPY --from=builder extract/third-party-dependencies/ $APP_HOME/
COPY --from=builder extract/inner-source-dependencies/ $APP_HOME/
COPY --from=builder extract/application/ $APP_HOME/

ENTRYPOINT java ${JAVA_OPTS} org.springframework.boot.loader.JarLauncher ${JAVA_ARGS}
EXPOSE 8080
EXPOSE 8081