package br.com.asv.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user")
public abstract class AClientAuth {

}
