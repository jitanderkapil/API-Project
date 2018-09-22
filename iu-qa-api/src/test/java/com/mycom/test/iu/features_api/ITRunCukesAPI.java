package com.mycom.test.iu.features_api;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(format = { "pretty", "html:target/cucumber", "json:target/cucumber.json" }, tags = { "~@ignore" })
public class ITRunCukesAPI
{}
