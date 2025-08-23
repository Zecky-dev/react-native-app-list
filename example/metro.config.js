const path = require('path');
const { getDefaultConfig, mergeConfig } = require('@react-native/metro-config');

const monorepoRoot = path.resolve(__dirname, '../');

const config = {
  resolver: {
    nodeModulesPaths: [path.resolve(monorepoRoot, 'node_modules')],
  },
  watchFolders: [monorepoRoot],
};

module.exports = mergeConfig(getDefaultConfig(__dirname), config);