import { NativeModules } from 'react-native';

const AppList = NativeModules.AppList;

if (!AppList) {
  console.warn(
    'WARN: Native AppList module is not available. ' +
    'Make sure the native module is correctly linked and rebuilt for your platform.'
  );
}

export function getInstalledApps(): Promise<{ appName: string; packageName: string }[]> {
  if (!AppList) {
    return Promise.reject(new Error('AppList native module is not available.'));
  }
  return AppList.getInstalledApps();
}

export function isAppInstalled(packageName: string): Promise<boolean> {
  if (!AppList) {
    return Promise.reject(new Error('AppList native module is not available.'));
  }
  return AppList.isAppInstalled(packageName);
}
