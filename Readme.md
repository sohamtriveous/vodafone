#things to do

Preferences
- create a method saveInPreferences(int position) to save the position in preferences
- Add a viewPager.addOnPageChangeListener to find out when a page is selected
  - in onPageSelected, call saveInPreferences

in onSavePreferences
- get a references to the SharedPreference in PreferenceManager.getDefaultSharedPreferences
- get a SharedPreferences.Editor from that
- put the position in that as a key/value pair
- execute the commit() method o nthe Editor

to retrieve the position from Preferences
- get a references to the SharedPreference in PreferenceManager.getDefaultSharedPreferences
- use the getInt method on sharedPreferences to get the position
- use the viewPager.setCurrentItem to set the viewpager position to the retrieved position