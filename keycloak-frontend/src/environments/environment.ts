import { KeycloakConfig } from 'keycloak-angular';

const keycloakConfig: KeycloakConfig = {
  url: 'http://localhost:8181/auth',
  realm: 'permission-test',
  clientId: 'frontendservice'
};

export const environment = {
  production: false,
  keycloakConfig
};
