package com.udea.domain;

import static com.udea.domain.ContratoTestSamples.*;
import static com.udea.domain.EmpleadoTestSamples.*;
import static com.udea.domain.TareaTestSamples.*;
import static com.udea.domain.TrabajoTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.udea.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class TrabajoTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Trabajo.class);
        Trabajo trabajo1 = getTrabajoSample1();
        Trabajo trabajo2 = new Trabajo();
        assertThat(trabajo1).isNotEqualTo(trabajo2);

        trabajo2.setId(trabajo1.getId());
        assertThat(trabajo1).isEqualTo(trabajo2);

        trabajo2 = getTrabajoSample2();
        assertThat(trabajo1).isNotEqualTo(trabajo2);
    }

    @Test
    void tareaTest() {
        Trabajo trabajo = getTrabajoRandomSampleGenerator();
        Tarea tareaBack = getTareaRandomSampleGenerator();

        trabajo.addTarea(tareaBack);
        assertThat(trabajo.getTareas()).containsOnly(tareaBack);

        trabajo.removeTarea(tareaBack);
        assertThat(trabajo.getTareas()).doesNotContain(tareaBack);

        trabajo.tareas(new HashSet<>(Set.of(tareaBack)));
        assertThat(trabajo.getTareas()).containsOnly(tareaBack);

        trabajo.setTareas(new HashSet<>());
        assertThat(trabajo.getTareas()).doesNotContain(tareaBack);
    }

    @Test
    void empleadoTest() {
        Trabajo trabajo = getTrabajoRandomSampleGenerator();
        Empleado empleadoBack = getEmpleadoRandomSampleGenerator();

        trabajo.setEmpleado(empleadoBack);
        assertThat(trabajo.getEmpleado()).isEqualTo(empleadoBack);

        trabajo.empleado(null);
        assertThat(trabajo.getEmpleado()).isNull();
    }

    @Test
    void contratoTest() {
        Trabajo trabajo = getTrabajoRandomSampleGenerator();
        Contrato contratoBack = getContratoRandomSampleGenerator();

        trabajo.setContrato(contratoBack);
        assertThat(trabajo.getContrato()).isEqualTo(contratoBack);
        assertThat(contratoBack.getTrabajo()).isEqualTo(trabajo);

        trabajo.contrato(null);
        assertThat(trabajo.getContrato()).isNull();
        assertThat(contratoBack.getTrabajo()).isNull();
    }
}
