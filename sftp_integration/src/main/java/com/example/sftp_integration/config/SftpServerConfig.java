package com.example.sftp_integration.config;

import com.jcraft.jsch.ChannelSftp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;

@Configuration
public class SftpConfig {

    @Bean
    public DefaultSftpSessionFactory sftpSessionFactory() {
        DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory(true);
        factory.setHost("${sftp.host}");
        factory.setPort(Integer.parseInt("${sftp.port}"));
        factory.setUser("${sftp.user}");
        factory.setPassword("${sftp.password}");
        factory.setAllowUnknownKeys(true);

        return factory;
    }
}
