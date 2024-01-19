package com.scholarshipholders.entrypoint.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scholarshipholders.core.model.CreateScholarModel;
import com.scholarshipholders.core.model.GetScholarModel;
import com.scholarshipholders.core.model.UpdateScholarModel;
import com.scholarshipholders.core.ports.in.service.IScholarServicePort;
import com.scholarshipholders.dummy.ScholarDummy;
import com.scholarshipholders.entrypoint.dto.request.CreateScholarRequestDTO;
import com.scholarshipholders.entrypoint.dto.request.UpdateScholarRequestDTO;
import com.scholarshipholders.entrypoint.dto.response.GetScholarResponseDTO;
import com.scholarshipholders.entrypoint.dto.response.UpdateScholarResponseDTO;
import com.scholarshipholders.entrypoint.mapper.IScholarEntrypointMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ScholarController.class)
class ScholarControllerTest {

   @MockBean
   private IScholarServicePort scholarServicePort;

   @MockBean
   private IScholarEntrypointMapper scholarEntrypointMapper;

   @Autowired
   private MockMvc mockMvc;

   @Autowired
   private ObjectMapper objectMapper;


    @Test
     void testGetScholar() throws Exception {
        UUID scholarId = UUID.randomUUID();
       GetScholarModel getScholarModel = ScholarDummy.getScholarModelBuilder().build();
       GetScholarResponseDTO getScholarResponseDTO = ScholarDummy.getScholarResponseDTOBuilder().build();

       when(scholarServicePort.getScholar(scholarId)).thenReturn(getScholarModel);
       when(scholarEntrypointMapper.fromGetScholarModelToGetScholarResponseDTO(getScholarModel)).thenReturn(getScholarResponseDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/scholars/{scholarId}", scholarId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName").value("John Doe"));
    }

   @Test
   void testGetScholars() throws Exception {
      List<GetScholarModel> getScholarModels = new ArrayList<>();
      GetScholarModel scholarModel1 = ScholarDummy.getScholarModelBuilder().build();
      scholarModel1.setId(UUID.randomUUID());

      GetScholarModel scholarModel2 = ScholarDummy.getScholarModelBuilder().build();
      scholarModel2.setId(UUID.randomUUID());

      getScholarModels.add(scholarModel1);
      getScholarModels.add(scholarModel2);

      List<GetScholarResponseDTO> expectedResponseDTOs = new ArrayList<>();
      GetScholarResponseDTO responseDTO1 = ScholarDummy.getScholarResponseDTOBuilder().build();
      responseDTO1.setId(scholarModel1.getId());

      GetScholarResponseDTO responseDTO2 = ScholarDummy.getScholarResponseDTOBuilder().build();
      responseDTO2.setId(scholarModel2.getId());

      expectedResponseDTOs.add(responseDTO1);
      expectedResponseDTOs.add(responseDTO2);

      when(scholarServicePort.getScholars()).thenReturn(getScholarModels);
      when(scholarEntrypointMapper.fromListGetScholarModelToListGetScholarResponseDTO(getScholarModels)).thenReturn(expectedResponseDTOs);

      mockMvc.perform(MockMvcRequestBuilders.get("/scholars"))
              .andExpect(status().isOk());
   }

   @Test
   void testCreateScholar() throws Exception {
      CreateScholarRequestDTO requestDTO = ScholarDummy.createScholarRequestDTOBuilder().build();
      CreateScholarModel createScholarModel = ScholarDummy.createScholarModelBuilder().build();

      when(scholarEntrypointMapper.fromCreateScholarRequestDTOToCreateScholarModel(requestDTO)).thenReturn(createScholarModel);

      mockMvc.perform(MockMvcRequestBuilders.post("/scholars")
                      .contentType(MediaType.APPLICATION_JSON)
                      .content(objectMapper.writeValueAsString(requestDTO)))
              .andExpect(status().isCreated());

      verify(scholarServicePort).createScholar(createScholarModel);
   }

   @Test
   void testUpdateScholar() throws Exception {
      UpdateScholarRequestDTO requestDTO =ScholarDummy.updateScholarRequestDTOBuilder().build();
      UpdateScholarModel updateScholarModel = ScholarDummy.updateScholarModelBuilder().build();
      UpdateScholarModel updatedScholarModel =  ScholarDummy.updateScholarModelBuilder().build();
      UpdateScholarResponseDTO expectedResponseDTO = ScholarDummy.updateScholarResponseDTOBuilder().build();

      when(scholarEntrypointMapper.fromUpdateScholarRequestDTOToUpdateScholarModel(requestDTO)).thenReturn(updateScholarModel);
      when(scholarServicePort.updateScholar(updateScholarModel)).thenReturn(updatedScholarModel);
      when(scholarEntrypointMapper.fromUpdateScholarModelToUpdateScholarResponseDTO(updatedScholarModel)).thenReturn(expectedResponseDTO);

      mockMvc.perform(MockMvcRequestBuilders.put("/scholars")
                      .contentType(MediaType.APPLICATION_JSON)
                      .content(objectMapper.writeValueAsString(requestDTO)))
              .andExpect(status().isOk());

      verify(scholarServicePort).updateScholar(updateScholarModel);
   }

   @Test
   void testDeleteScholar() throws Exception {
      UUID scholarId = UUID.randomUUID();

      mockMvc.perform(MockMvcRequestBuilders.delete("/scholars/{scholarId}", scholarId))
              .andExpect(status().isNoContent());
   }

}