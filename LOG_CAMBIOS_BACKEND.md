# LOG DE CAMBIOS — BACKEND RODAPP (Rama: oscar)

Este documento registra el progreso de la implementación lógica partiendo de la base de la rama 'santiago'.

---

## [2024-05-04] — Sincronización Total con Base 'santiago'
### Estado del Proyecto
- **Base de Código:** Se ha realizado un reset completo a la rama `santiago` para aprovechar toda la infraestructura de backend ya desarrollada.
- **Rama Actual:** `oscar`.
- **Archivos Clave Recuperados:** 
    - `SupabaseClient.kt`: Conexión activa con el proyecto Supabase.
    - `Models.kt`: Data classes para tablas de base de datos.
    - `AJUSTES_BACKEND_V1.md`: Guía técnica de lo implementado.

### Implementaciones Verificadas
1. **Paso 1: Autenticación**
    - `login.kt` y `register_user.kt` funcionales con Supabase Auth.
    - Persistencia automática de perfil en tabla `users`.
2. **Paso 2: Registro de Vehículo**
    - `RegistroMotoFragment.kt` funcional.
    - Persistencia en tabla `motos` y uso de `SharedViewModel` para contexto global.
3. **Paso 3: Documentación Obligatoria (SOAT)**
    - `RegistroSOATFragment.kt` funcional.
    - Selección de fechas con `MaterialDatePicker` y guardado en tabla `soat`.
4. **Paso 4: Documentación Obligatoria (RTM)**
    - `RegistroRTMFragment.kt` funcional.
    - Registro de certificado y CDA en tabla `rtm`.
5. **Paso 5: Gestión de Operación (Combustible)**
    - `CombustibleFragment.kt` funcional.
    - Registro de costo, tipo de gasolina y kilometraje en tabla `registros_combustible`.
6. **Paso 6: Gestión de Operación (Mantenimiento)**
    - `MantenimientoFragment.kt` funcional.
    - Soporte para recordatorios preventivos mediante `repetir_cada_km`.

### Próximo Paso en el Flujo
- **Módulo:** Visualización (Historial).
- **Acción:** Implementar o verificar la lógica de consulta para el Historial unificado.
