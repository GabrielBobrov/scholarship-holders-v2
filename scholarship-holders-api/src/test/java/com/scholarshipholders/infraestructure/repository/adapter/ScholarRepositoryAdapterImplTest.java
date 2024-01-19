package com.scholarshipholders.infraestructure.repository.adapter;

import com.scholarshipholders.core.model.CreateScholarModel;
import com.scholarshipholders.core.model.GetScholarModel;
import com.scholarshipholders.core.model.UpdateScholarModel;
import com.scholarshipholders.dummy.ScholarDummy;
import com.scholarshipholders.infrastructure.entity.ScholarEntity;
import com.scholarshipholders.infrastructure.mapper.IScholarInfrastructureMapper;
import com.scholarshipholders.infrastructure.repository.adapter.ISpringScholarRepositoryAdapter;
import com.scholarshipholders.infrastructure.repository.adapter.ScholarRepositoryAdapterImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class ScholarRepositoryAdapterImplTest {

    @Mock
    private ISpringScholarRepositoryAdapter springScholarRepository;

    @Mock
    private IScholarInfrastructureMapper scholarInfrastructureMapper;

    @InjectMocks
    private ScholarRepositoryAdapterImpl scholarRepositoryAdapter;

    @Test
    void testGetScholar() {
        UUID id = UUID.randomUUID();
        ScholarEntity scholarEntity = ScholarDummy.scholarEntityBuilder().build();
        GetScholarModel expectedModel = ScholarDummy.getScholarModelBuilder().build();

        when(springScholarRepository.findById(id)).thenReturn(java.util.Optional.of(scholarEntity));
        when(scholarInfrastructureMapper.fromScholarEntityToGetScholarModel(scholarEntity)).thenReturn(expectedModel);

        GetScholarModel actualModel = scholarRepositoryAdapter.getScholar(id);

        verify(springScholarRepository, times(1)).findById(id);
        verify(scholarInfrastructureMapper, times(1)).fromScholarEntityToGetScholarModel(scholarEntity);
        assertEquals(expectedModel, actualModel);
    }

    @Test
    void testCreateScholar() {
        CreateScholarModel createScholarModel = ScholarDummy.createScholarModelBuilder().build();
        ScholarEntity scholarEntity = ScholarDummy.scholarEntityBuilder().build();

        when(scholarInfrastructureMapper.fromCreateScholarModelToScholarEntity(createScholarModel)).thenReturn(scholarEntity);

        scholarRepositoryAdapter.createScholar(createScholarModel);

        verify(scholarInfrastructureMapper, times(1)).fromCreateScholarModelToScholarEntity(createScholarModel);
        verify(springScholarRepository, times(1)).save(scholarEntity);
    }

    @Test
    void testUpdateScholar() {
        UpdateScholarModel updateScholarModel = ScholarDummy.updateScholarModelBuilder().build();
        ScholarEntity scholarEntity = ScholarDummy.scholarEntityBuilder().build();
        UpdateScholarModel expectedModel = ScholarDummy.updateScholarModelBuilder().build();

        when(scholarInfrastructureMapper.fromUpdateScholarModelToScholarEntity(updateScholarModel)).thenReturn(scholarEntity);
        when(springScholarRepository.save(scholarEntity)).thenReturn(scholarEntity);
        when(scholarInfrastructureMapper.fromScholarEntityToUpdateScholarModel(scholarEntity)).thenReturn(expectedModel);

        UpdateScholarModel actualModel = scholarRepositoryAdapter.updateScholar(updateScholarModel);

        verify(scholarInfrastructureMapper, times(1)).fromUpdateScholarModelToScholarEntity(updateScholarModel);
        verify(springScholarRepository, times(1)).save(scholarEntity);
        verify(scholarInfrastructureMapper, times(1)).fromScholarEntityToUpdateScholarModel(scholarEntity);
        assertEquals(expectedModel, actualModel);
    }

    @Test
    void testDeleteScholar() {
        GetScholarModel getScholarModel = ScholarDummy.getScholarModelBuilder().build();
        ScholarEntity scholarEntity = ScholarDummy.scholarEntityBuilder().build();

        when(scholarInfrastructureMapper.fromGetScholarModelTScholarEntity(getScholarModel)).thenReturn(scholarEntity);

        scholarRepositoryAdapter.deleteScholar(getScholarModel);

        verify(scholarInfrastructureMapper, times(1)).fromGetScholarModelTScholarEntity(getScholarModel);
        verify(springScholarRepository, times(1)).delete(scholarEntity);
    }
}