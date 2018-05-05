package com.springIntegration.dynamic.models;

import org.springframework.stereotype.Component;

@Component
public class ChannelFlowBean {
	
	private String transformer1InputChannel;
	private String transformer1OutputChannel;
	private String transformer2InputChannel;
	private String transformer2OutputChannel;
	
	private String serviceActivator1InputChannel;
	private String serviceActivator1OutputChannel;
	private String serviceActivator2InputChannel;
	private String serviceActivator2OutputChannel;
	
	private String axisGatewayOutputChannel;
	private String paytmGatewayOutputChannel;
	private String upiGatewayOutputChannel;
	
	
	public String getTransformer1InputChannel() {
		return transformer1InputChannel;
	}
	public void setTransformer1InputChannel(String transformer1InputChannel) {
		this.transformer1InputChannel = transformer1InputChannel;
	}
	public String getTransformer1OutputChannel() {
		return transformer1OutputChannel;
	}
	public void setTransformer1OutputChannel(String transformer1OutputChannel) {
		this.transformer1OutputChannel = transformer1OutputChannel;
	}
	public String getTransformer2InputChannel() {
		return transformer2InputChannel;
	}
	public void setTransformer2InputChannel(String transformer2InputChannel) {
		this.transformer2InputChannel = transformer2InputChannel;
	}
	public String getTransformer2OutputChannel() {
		return transformer2OutputChannel;
	}
	public void setTransformer2OutputChannel(String transformer2OutputChannel) {
		this.transformer2OutputChannel = transformer2OutputChannel;
	}
	public String getServiceActivator1InputChannel() {
		return serviceActivator1InputChannel;
	}
	public void setServiceActivator1InputChannel(String serviceActivator1InputChannel) {
		this.serviceActivator1InputChannel = serviceActivator1InputChannel;
	}
	public String getServiceActivator1OutputChannel() {
		return serviceActivator1OutputChannel;
	}
	public void setServiceActivator1OutputChannel(String serviceActivator1OutputChannel) {
		this.serviceActivator1OutputChannel = serviceActivator1OutputChannel;
	}
	public String getServiceActivator2InputChannel() {
		return serviceActivator2InputChannel;
	}
	public void setServiceActivator2InputChannel(String serviceActivator2InputChannel) {
		this.serviceActivator2InputChannel = serviceActivator2InputChannel;
	}
	public String getServiceActivator2OutputChannel() {
		return serviceActivator2OutputChannel;
	}
	public void setServiceActivator2OutputChannel(String serviceActivator2OutputChannel) {
		this.serviceActivator2OutputChannel = serviceActivator2OutputChannel;
	}
	public String getAxisGatewayOutputChannel() {
		return axisGatewayOutputChannel;
	}
	public void setAxisGatewayOutputChannel(String axisGatewayOutputChannel) {
		this.axisGatewayOutputChannel = axisGatewayOutputChannel;
	}
	public String getPaytmGatewayOutputChannel() {
		return paytmGatewayOutputChannel;
	}
	public void setPaytmGatewayOutputChannel(String paytmGatewayOutputChannel) {
		this.paytmGatewayOutputChannel = paytmGatewayOutputChannel;
	}
	public String getUpiGatewayOutputChannel() {
		return upiGatewayOutputChannel;
	}
	public void setUpiGatewayOutputChannel(String upiGatewayOutputChannel) {
		this.upiGatewayOutputChannel = upiGatewayOutputChannel;
	}
	
	

}
