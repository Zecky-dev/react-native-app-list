import { useEffect } from 'react';
import { Text, View, StyleSheet } from 'react-native';
import { getInstalledApps, isAppInstalled } from '@zecky-dev/react-native-app-list';

export default function App() {
  
  useEffect(() => {
    isAppInstalled('com.android.chrome').then((isInstalled) => console.log('CHROME_INSTALLED', isInstalled)).catch((error) => console.log('IS_APP_INSTALLED_ERROR', error))
  }, []);

  return (
    <View style={styles.container}>

    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});
