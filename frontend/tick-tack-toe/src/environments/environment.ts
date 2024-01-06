export const environment = {
// @ts-ignore
//   location: window['env']['BASE_URL']
  location: window['env'] && window['env']['BASE_URL'] ? window['env']['BASE_URL'] : 'default_value',
};
