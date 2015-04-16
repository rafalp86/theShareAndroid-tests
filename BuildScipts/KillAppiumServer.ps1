$appiumProcess='node'
$emulatorProcess='emulator'
$AppiumProcessCount=(Get-Process | Where {$_.ProcessName -eq $appiumProcess} |measure).Count
$EmulatorProcessCount=(Get-Process | Where {$_.ProcessName -eq $emulatorProcess} |measure).Count

Write-Host $AppiumProcessCount , $EmulatorProcessCount
 "Stop Appium server"
 Get-Process | Where {$_.ProcessName -eq $appiumProcess} | foreach{$_.Kill()}
"Kill emulator"
Get-Process | Where {$_.ProcessName -eq $emulatorProcess} | foreach{$_.Kill()}
   





