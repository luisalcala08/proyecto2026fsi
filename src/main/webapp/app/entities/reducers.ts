import tarea from 'app/entities/tarea/tarea.reducer';
import contrato from 'app/entities/contrato/contrato.reducer';
import departamento from 'app/entities/departamento/departamento.reducer';
import direccion from 'app/entities/direccion/direccion.reducer';
import empleado from 'app/entities/empleado/empleado.reducer';
import pais from 'app/entities/pais/pais.reducer';
import region from 'app/entities/region/region.reducer';
import trabajo from 'app/entities/trabajo/trabajo.reducer';
/* jhipster-needle-add-reducer-import - JHipster will add reducer here */

const entitiesReducers = {
  tarea,
  contrato,
  departamento,
  direccion,
  empleado,
  pais,
  region,
  trabajo,
  /* jhipster-needle-add-reducer-combine - JHipster will add reducer here */
};

export default entitiesReducers;
