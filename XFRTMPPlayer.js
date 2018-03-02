import PropTypes from 'prop-types';
import {requireNativeComponent, ViewPropTypes} from 'react-native';

var iface = {
  name: 'XFRTMPPlayer',
  propTypes: {
    src: PropTypes.string,
    ...ViewPropTypes, // include the default view properties
  },
};

module.exports = requireNativeComponent('XFRTMPPlayer', iface);
