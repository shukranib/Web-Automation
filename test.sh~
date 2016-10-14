#!/bin/bash
import jenkins.model.*;
def days = 180
def jobName = "test_dummy"
def j = Jenkins.instance.getItemByFullName(jobName);
j.getBuilds().byTimestamp(1, System.currentTimeMillis() - (1000L * 60 * 60 * 24 * days)).each { it.getLogFile().delete(); it.getLogFile().createNewFile() }
