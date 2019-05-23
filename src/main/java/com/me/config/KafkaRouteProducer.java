package com.me.config;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaConstants;

public class KafkaRouteProducer extends RouteBuilder {

	private String route;

	public KafkaRouteProducer(String route) {
		this.route = route;
	}

	public void configure() {
		from("direct:kafkaRoute").process(new Processor() {
			@Override
			public void process(Exchange exchange) throws Exception {
				String message = exchange.getIn().getBody().toString();
				if(message.startsWith(Constants.FIRSTTOPIC)) {
				exchange.getIn().setHeader(KafkaConstants.TOPIC, Constants.FIRSTTOPIC);
				exchange.getIn().setHeader(KafkaConstants.KEY, "1");
				} else if(message.startsWith(Constants.SECONDTOPIC)) {
					exchange.getIn().setHeader(KafkaConstants.TOPIC, Constants.SECONDTOPIC);
					exchange.getIn().setHeader(KafkaConstants.KEY, "2");
					}
			}
		}).to(this.route);
	}
}
