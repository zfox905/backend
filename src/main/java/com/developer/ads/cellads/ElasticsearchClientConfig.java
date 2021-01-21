package com.developer.ads.cellads;



import java.io.IOException;
import java.net.InetAddress;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestClientBuilder.HttpClientConfigCallback;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import com.developer.ads.cellads.repository.CellPhoneRepository;

@Configuration
@EnableElasticsearchRepositories(basePackages 
        = "com.developer.ads.cellads.repository")
@ComponentScan(basePackages = { "com.developer.ads" })
public class ElasticsearchClientConfig  {
	

	private String userName = "OJUOlpEtT";
	private String password ="9f290faf-7bd6-4319-b7c6-b6c7a28c3c71";
	
	private int  port =443;
	
	private String host ="nvidovic-osvpoew-es.searchbase.io";
	

	@Bean(destroyMethod = "close")
	public RestHighLevelClient restClient() {
		

	  final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
	
	  credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(userName, password));
	
	  RestClientBuilder builder = RestClient.builder ( new HttpHost(host, port, "https"))
	
	  .setHttpClientConfigCallback(new HttpClientConfigCallback() {
	      @Override
	      public HttpAsyncClientBuilder customizeHttpClient(
	              HttpAsyncClientBuilder httpClientBuilder) {
	          return httpClientBuilder
	              .setDefaultCredentialsProvider(credentialsProvider);
	      }
	  });
	  RestHighLevelClient client = new RestHighLevelClient(builder);

  	
  
   
  
  return client; 
  
	}

  
  
}
