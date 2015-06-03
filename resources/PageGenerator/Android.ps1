
. .\GetXmlSnapshot.ps1

$file =getxml ".\"
"xml file: "+$file
$resourceList=Select-Xml -Path $file -XPath "//*[contains(@resource-id,'com.')]/@resource-id" | ForEach-Object { $_.Node }
if (($resourceList | Measure-Object).Count -eq 0) { return "Brak rezultatów " }

$Resultfile='.\result.txt'
foreach ($resorec in $resourceList)
{ #private By LoginResetButton= GetBy.ResourceId("login_reset_password");
    'private By '+$resorec.Value.Split('/')[1] +'Element = GetBy.ResourceId("'+$resorec.Value+'");' 
}


'-------------'
$ButtonList=Select-Xml -Path $file -XPath "//*[@class='android.widget.Button']/@resource-id |//*[@class='android.widget.ImageButton']/@resource-id  " | ForEach-Object { $_.Node }
if (($ButtonList | Measure-Object).Count -eq 0) { return "Brak przycisków " }
foreach ($button in $ButtonList)
{
  $Name=$button.Value.Split('/')[1].ToString();
  $SplitName= $Name.Split('_') | foreach {$_.Remove(0,1).Insert(0,$_[0].ToString().ToUpper())}
  '                      -->'+$SplitName

  'public LogInPage  Tap'+$Name+'{' 
  '  Click('+$Name +'Element);'
  'return this;'
  '}'
}




#public LogInPage TapCreateAccount()
#	{
#		Click(CreateAccountButton);
#		return this;
#	}
'------'