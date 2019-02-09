package com.lhd.broadcastapi.subscription;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class SubscriptionControllerTest {

  @Mock
  private SubscriptionService subscriptionServiceMock;

  @InjectMocks
  private SubscriptionController subscriptionController;


  @Test
  public void save() {
    SubscriptionRequestDto subscriptionRequestDto = new SubscriptionRequestDto();

    ResponseEntity<?> responseEntity = subscriptionController.save(subscriptionRequestDto);

    assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
  }

}
