package io.aharo.inbox;


import io.aharo.inbox.folders.Folder;
import io.aharo.inbox.folders.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.oss.driver.api.core.uuid.Uuids;

import javax.annotation.PostConstruct;
import java.nio.file.Path;
import java.util.Arrays;


@SpringBootApplication
@RestController
public class InboxApp
{
	// @Autowired 
	// private FolderRepository folderRepository;
	
 

	public static void main(String[] args) {
		SpringApplication.run(InboxApp.class, args);
	}

	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer (DataStaxAstraProperties astraProperties)
	{
		Path bundle = astraProperties.getSecureConnectBundle().toPath();
		return builder -> builder.withCloudSecureConnectBundle(bundle);
	}

	

}

  
