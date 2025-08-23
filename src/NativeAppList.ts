import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';

export interface Spec extends TurboModule {
  getAllInstalledApps(): Promise<Array<{ appName: string; packageName: string }>>;
  isAppInstalled(packageName: string): Promise<boolean>;
}

export default TurboModuleRegistry.getEnforcing<Spec>('AppList');