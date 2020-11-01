#!/usr/bin/env bash

 cd /opt/tests/imburse-qa
 mvn clean test -Dcucumber.options="${CUCUMBER_OPTIONS}"