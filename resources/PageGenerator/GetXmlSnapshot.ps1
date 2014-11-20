
function  getxml ($filepath)
 {
     adb shell ls "/system/bin/uiautomator" |Out-Null
     adb shell rm "/sdcard/uidump.xml" |Out-Null
     adb shell "/system/bin/uiautomator" dump  "/sdcard/uidump.xml" |Out-Null
     adb pull  "/sdcard/uidump.xml"  ($filepath+"uidump.xml") |Out-Null
     adb shell rm  "/sdcard/screenshot.png" |Out-Null
     adb shell screencap -p "/sdcard/screenshot.png" |Out-Null
     adb pull "/sdcard/screenshot.png" ($filepath+"screenshot.png")|Out-Null
  
 return ($filepath+"uidump.xml")
 }