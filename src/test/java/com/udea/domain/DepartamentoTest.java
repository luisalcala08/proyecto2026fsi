package com.udea.domain;

import static com.udea.domain.ContratoTestSamples.*;
import static com.udea.domain.DepartamentoTestSamples.*;
import static com.udea.domain.DireccionTestSamples.*;
import static com.udea.domain.EmpleadoTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.udea.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class DepartamentoTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Departamento.class);
        Departamento departamento1 = getDepartamentoSample1();
        Departamento departamento2 = new Departamento();
        assertThat(departamento1).isNotEqualTo(departamento2);

        departamento2.setId(departamento1.getId());
        assertThat(departamento1).isEqualTo(departamento2);

        departamento2 = getDepartamentoSample2();
        assertThat(departamento1).isNotEqualTo(departamento2);
    }

    @Test
    void direccionTest() {
        Departamento departamento = getDepartamentoRandomSampleGenerator();
        Direccion direccionBack = getDireccionRandomSampleGenerator();

        departamento.setDireccion(direccionBack);
        assertThat(departamento.getDireccion()).isEqualTo(direccionBack);

        departamento.direccion(null);
        assertThat(departamento.getDireccion()).isNull();
    }

    @Test
    void empleadoTest() {
        Departamento departamento = getDepartamentoRandomSampleGenerator();
        Empleado empleadoBack = getEmpleadoRandomSampleGenerator();

        departamento.addEmpleado(empleadoBack);
        assertThat(departamento.getEmpleados()).containsOnly(empleadoBack);
        assertThat(empleadoBack.getDepartamento()).isEqualTo(departamento);

        departamento.removeEmpleado(empleadoBack);
        assertThat(departamento.getEmpleados()).doesNotContain(empleadoBack);
        assertThat(empleadoBack.getDepartamento()).isNull();

        departamento.empleados(new HashSet<>(Set.of(empleadoBack)));
        assertThat(departamento.getEmpleados()).containsOnly(empleadoBack);
        assertThat(empleadoBack.getDepartamento()).isEqualTo(departamento);

        departamento.setEmpleados(new HashSet<>());
        assertThat(departamento.getEmpleados()).doesNotContain(empleadoBack);
        assertThat(empleadoBack.getDepartamento()).isNull();
    }

    @Test
    void contratoTest() {
        Departamento departamento = getDepartamentoRandomSampleGenerator();
        Contrato contratoBack = getContratoRandomSampleGenerator();

        departamento.setContrato(contratoBack);
        assertThat(departamento.getContrato()).isEqualTo(contratoBack);
        assertThat(contratoBack.getDepartamento()).isEqualTo(departamento);

        departamento.contrato(null);
        assertThat(departamento.getContrato()).isNull();
        assertThat(contratoBack.getDepartamento()).isNull();
    }
}
