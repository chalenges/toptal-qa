#!/usr/bin/env bash

 cd /opt/tests/imburse-qa
 mvn clean test -Dcucumber.filter.tags="${CUCUMBER_OPTIONS}"