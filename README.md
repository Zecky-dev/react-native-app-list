# @zecky-dev/react-native-app-list

This module offers a simple and efficient way to list all installed apps and check for a specific one on the **Android** platform.

## Installation

```sh
npm install @zecky-dev/react-native-app-list
```

## Usage

### 1. Get All Installed Apps

This method returns a `Promise` that resolves to an array of `AppInfo` objects, where each object represents an installed application on the device.

```javascript
import { getInstalledApps } from "@zecky-dev/react-native-app-list";
async function listInstalledApps() {
  try {
    const apps = await getInstalledApps(); /* : AppInfo[] */
    console.log("Installed Apps:", apps);
    // Example output for 'apps':
    // [
    //   { appName: "Google Chrome", packageName: "com.android.chrome" },
    //   { appName: "WhatsApp", packageName: "com.whatsapp" },
    //   // ... other installed apps
    // ]
  } catch (error) {
    console.error("Failed to get installed apps:", error);
  }
}
listInstalledApps();
```

### AppInfo Type

```typescript
type AppInfo = {
  appName: string; // The display name of the app (e.g., "Instagram")
  packageName: string; // The unique package name of the app (e.g., "com.instagram.android")
};
```


### 2. Check Installed App by Package Name

This method is used to check if a specific app is installed on the device. It returns a `Promise<boolean>` that resolves to `true` if the app is installed, and `false` otherwise.

```js
import { isAppInstalled } from "@zecky-dev/react-native-app-list";
async function checkChromeInstallation() {
  try {
    // Check for the Google Chrome app using its package name
    const isInstalled = await isAppInstalled("com.android.chrome");

    if (isInstalled) {
      console.log("Google Chrome is installed on this device.");
    } else {
      console.log("Google Chrome is not installed on this device.");
    }
  } catch (error) {
    console.error("Error checking app installation:", error);
  }
}
checkChromeInstallation();
```

### ❓ How to Find an App's Package Name
You can find an app's package name directly from its Google Play Store URL. The package name is the part of the URL after ?id=.

For example:

Google Chrome: https://play.google.com/store/apps/details?id=com.android.chrome

Package Name: com.android.chrome

## License

MIT – Do whatever you want with it, no warranty.
