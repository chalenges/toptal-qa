FROM maven:3.5-alpine
MAINTAINER qae@jmc

RUN mkdir -p /opt/tests
ADD imburse-qa.tar.gz /opt/tests
RUN cd /opt/tests && ls
RUN chmod +x /opt/tests/imburse-qa/build/run_tests.sh
RUN mvn install:install-file \
  -Dfile=/opt/tests/imburse-qa/build/bug-catcher-1.0.0.jar \
  -DgroupId=qae \
  -DartifactId=bug-catcher \
  -Dversion=1.0.0 \
  -Dpackaging=jar
  
RUN cd /opt/tests/imburse-qa/ && mvn install -Dmaven.test.skip=true

WORKDIR /opt/tests

CMD /opt/tests/imburse-qa/build/run_tests.sh
