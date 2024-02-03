package com.beniaminoleone.booking.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "availability-service", url = "http://localhost:53016/api/v1")
public interface AvailabilityClient {

    @RequestMapping(method = RequestMethod.GET, value = "/availability", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> getAvailability(@PathVariable("id") Long id );
}
