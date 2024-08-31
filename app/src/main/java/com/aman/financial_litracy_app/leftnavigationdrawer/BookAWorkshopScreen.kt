package com.aman.financial_litracy_app.leftnavigationdrawer


import android.widget.RadioGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aman.financial_litracy_app.R
import com.aman.financial_litracy_app.navigation.Screens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookAWorkshopScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.systemBarsPadding().navigationBarsPadding(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text ="Book a Workshop",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription ="Back Button" )
                    }
                }
            )
        },
        content = {
            var yourName by remember { mutableStateOf("") }
            var yourEmail by remember { mutableStateOf("") }
            var schoolName by remember { mutableStateOf("") }
            var schoolDistrict by remember { mutableStateOf("") }
            var workshopGradesAndClasses by remember { mutableStateOf("") }
            var workshopStartDate by remember { mutableStateOf("") }
            var whichEducator by remember { mutableStateOf("") }
            var workshopDeliveryFormat by remember { mutableStateOf("") }


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .padding(it)
                    .verticalScroll(rememberScrollState())
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_workshop),
                    contentDescription =null,
                    modifier = Modifier.fillMaxWidth()
                    )


                // About You section
                SectionTitle(text = "About You")
                DescText(text = "Your Name")
                OutlinedTextField(
                    value = yourName,
                    onValueChange = { yourName = it },
                    label = { Text("Enter Your Full Name") },
                    modifier = Modifier.fillMaxWidth()
                )
                DescText(text = "Your Email")
                OutlinedTextField(
                    value = yourEmail,
                    onValueChange = { yourEmail = it },
                    label = { Text("Enter Your Email") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier.fillMaxWidth()
                )

                // About Your School section
                SectionTitle(text = "About Your School")
                
                DescText(text = "School name")
                OutlinedTextField(
                    value = schoolName,
                    onValueChange = { schoolName = it },
                    label = { Text("School Name") },
                    modifier = Modifier.fillMaxWidth()
                )
                DescText(text = "School District")
                OutlinedTextField(
                    value = schoolDistrict,
                    onValueChange = { schoolDistrict = it },
                    label = { Text("School District") },
                    modifier = Modifier.fillMaxWidth()
                )

                DescText(text = "Has your school hosted our Financial Educational Workshops before?")
                Row {
                    val hasHostedWorkshops by remember { mutableStateOf(false) }

                    Checkbox(checked =hasHostedWorkshops , onCheckedChange = {})
                    Text(text = "Yes", modifier = Modifier.align(Alignment.CenterVertically))
                    val hasHostedWorkshopsNegative by remember { mutableStateOf(false) }
                    Checkbox(checked =hasHostedWorkshopsNegative , onCheckedChange = {})
                    Text(text = "No", modifier = Modifier.align(Alignment.CenterVertically))
                }


//                TODO here you have to implement the checkbox code
//                Checkbox(
//                    checked = hasHostedWorkshops,
//                    onCheckedChange = { hasHostedWorkshops = it },
//                    label = { Text("Has your school hosted our Financial Educational Workshops before?") }
//                )

                // About the Workshops section
                SectionTitle(text = "About the Workshops")
                //                TODO here you have to implement the checkbox code
                DescText(text = "How could you like the workshops delivered")
                Row {

                    val inPerson by remember { mutableStateOf(false) }
                    Checkbox(checked =inPerson , onCheckedChange = {})
                    Text(text = "In-Person", modifier = Modifier.align(Alignment.CenterVertically))


                    val online by remember { mutableStateOf(false) }
                    Checkbox(checked =online , onCheckedChange = {})
                    Text(text = "Online", modifier = Modifier.align(Alignment.CenterVertically))

                    val either by remember { mutableStateOf(false) }
                    Checkbox(checked =either , onCheckedChange = {})
                    Text(text = "either", modifier = Modifier.align(Alignment.CenterVertically))
                }


//                RadioGroup(
//                    selectedRadio = workshopDelivery,
//                    onSelectedChange = { workshopDelivery = it },
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    RadioOption(
//                        text = "In-Person",
//                        value = "In-Person"
//                    )
//                    RadioOption(
//                        text = "Online",
//                        value = "Online"
//                    )
//                    RadioOption(
//                        text = "Either",
//                        value = "Either"
//                    )
//                }

                DescText(text = "Which grades would you like Financial Educational Workshops for and how many classes are in each grade?")
                OutlinedTextField(
                    value = workshopGradesAndClasses,
                    onValueChange = { workshopGradesAndClasses = it },
                    label = { Text("Description Here") },
                    modifier = Modifier.fillMaxWidth()
                )

//                Checkbox(
//                    checked = hasWorkshopForParents,
//                    onCheckedChange = { hasWorkshopForParents = it },
//                    label = { Text("Would you like to have a workshop for parents?") }
//                )
                DescText(text = "would you like to have a  workshops for parents?")
                var parentsWorkshopY by remember { mutableStateOf(false) }
                var parentsWorkshopN by remember { mutableStateOf(false) }
                Row {
                    Checkbox(checked = parentsWorkshopY, onCheckedChange = { parentsWorkshopY = it})
                    Text(text = "Yes", modifier = Modifier.align(Alignment.CenterVertically))
                    Checkbox(checked = parentsWorkshopN, onCheckedChange = { parentsWorkshopN = it})
                    Text(text = "Yes", modifier = Modifier.align(Alignment.CenterVertically))
                }


                DescText(text = "Ideally,When would you like these workshops to take place?")
                OutlinedTextField(
                    value = workshopStartDate,
                    onValueChange = { workshopStartDate = it },
                    modifier = Modifier.fillMaxWidth()
                )

                DescText(text = "Do you have a preference for which educator on our team visits your school?")
                OutlinedTextField(
                    value = whichEducator,
                    onValueChange = { whichEducator = it },
                    modifier = Modifier.fillMaxWidth()
                )
                DescText(text = "Which Workshop delivery format works best for your School? Click Here to select options?")
                OutlinedTextField(
                    value = workshopDeliveryFormat,
                    onValueChange = { workshopDeliveryFormat = it },
                    modifier = Modifier.fillMaxWidth()
                )


                Row {
                    var permission1 by remember { mutableStateOf(false) }
                    Checkbox(checked = permission1, onCheckedChange = { permission1 = it})
                    Text(
                        text = "I have read and agree to the Terms and Conditions",
                        modifier=Modifier.align(Alignment.CenterVertically)
                    )
                }
                Row {
                    var permission2 by remember { mutableStateOf(false) }
                    Checkbox(checked = permission2, onCheckedChange = { permission2 = it})
                    Text(
                        text = "I believe my school is eligible for funding",
                        modifier=Modifier.align(Alignment.CenterVertically)
                    )
                }


                Button(
                    onClick = {
                        // Handle submit]
                        navController.navigate(Screens.HomeScreen.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .height(50.dp)
                        .background(color = Color.White),
                    shape = RoundedCornerShape(10.dp)// Adjust button padding
                ) {
                    Text(text = "Submit", color = Color.White) // White text on primary background
                }
            }
        }
    )


}
//@Preview
//@Composable
//fun BookAWorkshopScreenPreview(modifier: Modifier = Modifier) {
//    BookAWorkshopScreen()
//}

@Composable
fun SectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(top = 16.dp, bottom = 8.dp)
            .fillMaxWidth()
    )
}

@Composable
fun DescText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, bottom = 5.dp)
    )
}