package com.scholarshipholders.core.adapter.service;

import com.scholarshipholders.core.model.CreateScholarModel;
import com.scholarshipholders.core.model.GetScholarModel;
import com.scholarshipholders.core.model.UpdateScholarModel;
import com.scholarshipholders.core.ports.out.repository.IScholarRepositoryPort;
import com.scholarshipholders.dummy.ScholarDummy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ScholarServiceAdapterImplTest {

    @Mock
    private IScholarRepositoryPort scholarRepositoryPort;

    @InjectMocks
    private ScholarServiceAdapterImpl scholarServiceAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetScholar() {
        UUID id = UUID.randomUUID();
        GetScholarModel expectedModel = ScholarDummy.getScholarModelBuilder().build();

        when(scholarRepositoryPort.getScholar(id)).thenReturn(expectedModel);

        GetScholarModel actualModel = scholarServiceAdapter.getScholar(id);

        verify(scholarRepositoryPort, times(1)).getScholar(id);
        assertEquals(expectedModel, actualModel);
    }

    @Test
    void testGetScholars() {
        List<GetScholarModel> expectedModels = new ArrayList<>();
        expectedModels.add(ScholarDummy.getScholarModelBuilder().build());

        when(scholarRepositoryPort.getScholars()).thenReturn(expectedModels);

        List<GetScholarModel> actualModels = scholarServiceAdapter.getScholars();

        verify(scholarRepositoryPort, times(1)).getScholars();
        assertEquals(expectedModels, actualModels);
    }

    @Test
    void testCreateScholar() {
        CreateScholarModel createScholarModel = ScholarDummy.createScholarModelBuilder().build();

        scholarServiceAdapter.createScholar(createScholarModel);

        verify(scholarRepositoryPort, times(1)).createScholar(createScholarModel);
    }

    @Test
    void testUpdateScholar() {
        UpdateScholarModel updateScholarModel = ScholarDummy.updateScholarModelBuilder().build();
        GetScholarModel scholar = ScholarDummy.getScholarModelBuilder().build();
        updateScholarModel.setId(UUID.randomUUID());
        scholar.setCreatedAt(LocalDate.parse("2022-01-01"));

        when(scholarRepositoryPort.getScholar(updateScholarModel.getId())).thenReturn(scholar);
        when(scholarRepositoryPort.updateScholar(updateScholarModel)).thenReturn(updateScholarModel);

        UpdateScholarModel actualModel = scholarServiceAdapter.updateScholar(updateScholarModel);

        verify(scholarRepositoryPort, times(1)).getScholar(updateScholarModel.getId());
        verify(scholarRepositoryPort, times(1)).updateScholar(updateScholarModel);
        assertEquals(updateScholarModel, actualModel);
    }

    @Test
    void testDeleteScholar() {
        UUID id = UUID.randomUUID();
        GetScholarModel scholar =ScholarDummy.getScholarModelBuilder().build();
        scholar.setId(id);

        when(scholarRepositoryPort.getScholar(id)).thenReturn(scholar);

        scholarServiceAdapter.deleteScholar(id);

        verify(scholarRepositoryPort, times(1)).getScholar(id);
        verify(scholarRepositoryPort, times(1)).deleteScholar(scholar);
    }
}