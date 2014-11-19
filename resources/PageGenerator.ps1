cls

$file ='C:\Users\Rafał\Documents\test\dump_8444729755785990257.uix'
$PageName='WallPage'

$resourceList=Select-Xml -Path $file -XPath "//*[contains(@resource-id,'com.')]/@resource-id" | ForEach-Object { $_.Node }

'-------------'
$ButtonList=Select-Xml -Path $file -XPath "//*[@class='android.widget.Button']/@resource-id |//*[@class='android.widget.ImageButton']/@resource-id  " | ForEach-Object { $_.Node }
foreach ($button in $ButtonList)
{
  $Name=$button.Value.Split('/')[1].ToString();
  $SplitName= $Name.Split('_') | foreach {$_.Remove(0,1).Insert(0,$_[0].ToString().ToUpper())}
  $Value='';
  foreach($name in $SplitName) {$Value+=$name}
  'public '+$PageName+'  Tap'+$Value+'(){'
  '  Click('+$Value +'Element);'
  '  return this;'
  '}'
}

#public LogInPage TapCreateAccount()
#    {
#        Click(CreateAccountButton);
#        return this;
#    }
'------'


foreach ($resorec in $resourceList)
{ #private By LoginResetButton= GetBy.ResourceId("com.example.theshare:id/login_reset_password");
    $Name=$resorec.Value.Split('/')[1].ToString();
  $SplitName= $Name.Split('_') | foreach {$_.Remove(0,1).Insert(0,$_[0].ToString().ToUpper())}
 
  $Value='';
  foreach($name in $SplitName) {$Value+=$name}
    'private By '+$Value+'Element = GetBy.ResourceId("'+$resorec.Value +'");' 
}

