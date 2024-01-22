package com.scholarshipholders.entrypoint.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scholarshipholders.core.model.payment.CreatePaymentModel;
import com.scholarshipholders.core.ports.in.service.IPaymentServicePort;
import com.scholarshipholders.dummy.PaymentDummy;
import com.scholarshipholders.entrypoint.dto.request.payment.CreatePaymentRequestDTO;
import com.scholarshipholders.entrypoint.mapper.IPaymentEntrypointMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PaymentController.class)
class PaymentControllerTest {

   @MockBean
   private IPaymentServicePort paymentServicePort;

   @MockBean
   private IPaymentEntrypointMapper paymentEntrypointMapper;

   @Autowired
   private MockMvc mockMvc;

   @Autowired
   private ObjectMapper objectMapper;


   @Test
   void testCreatePayment() throws Exception {
      CreatePaymentRequestDTO createPaymentRequestDTO = PaymentDummy.createPaymentRequestDTOBuilder().build();
      CreatePaymentModel createPaymentModel = PaymentDummy.createPaymentModelBuilder().build();
      UUID scholarId = UUID.randomUUID();

      String json = objectMapper.writeValueAsString(createPaymentRequestDTO);

      when(paymentEntrypointMapper.fromCreatePaymentRequestDTOToCreatePaymentModel(createPaymentRequestDTO)).thenReturn(createPaymentModel);

      mockMvc.perform(post("/scholars/" + scholarId + "/payments")
                      .content(json)
                      .contentType(MediaType.APPLICATION_JSON))
              .andExpect(status().isCreated())
              .andReturn();
   }

   @Test
   void testGetPayments() throws Exception {
      when(paymentServicePort.getPayments(any(UUID.class))).thenReturn(Collections.emptyList());

      mockMvc.perform(get("/scholars/" + UUID.randomUUID() + "/payments"))
              .andExpect(status().isOk());
   }

   @Test
   void testDeletePayment() throws Exception {
      mockMvc.perform(delete("/scholars/" + UUID.randomUUID() + "/payments/" + UUID.randomUUID()))
              .andExpect(status().isNoContent());
   }


}