import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import Tarea from './tarea';
import Contrato from './contrato';
import Departamento from './departamento';
import Direccion from './direccion';
import Empleado from './empleado';
import Pais from './pais';
import Region from './region';
import Trabajo from './trabajo';
/* jhipster-needle-add-route-import - JHipster will add routes here */

export default () => {
  return (
    <div>
      <ErrorBoundaryRoutes>
        {/* prettier-ignore */}
        <Route path="tarea/*" element={<Tarea />} />
        <Route path="contrato/*" element={<Contrato />} />
        <Route path="departamento/*" element={<Departamento />} />
        <Route path="direccion/*" element={<Direccion />} />
        <Route path="empleado/*" element={<Empleado />} />
        <Route path="pais/*" element={<Pais />} />
        <Route path="region/*" element={<Region />} />
        <Route path="trabajo/*" element={<Trabajo />} />
        {/* jhipster-needle-add-route-path - JHipster will add routes here */}
      </ErrorBoundaryRoutes>
    </div>
  );
};
