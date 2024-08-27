package com.aman.financial_litracy_app.leftnavigationdrawer


import android.widget.RadioGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aman.financial_litracy_app.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookAWorkshopScreen(modifier: Modifier = Modifier) {
    Scaffold(
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
                    IconButton(onClick = { /*TODO*/ }) {
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
            var preferredEducator by remember { mutableStateOf("") }


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
                OutlinedTextField(
                    value = yourName,
                    onValueChange = { yourName = it },
                    label = { Text("Enter Your Full Name") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = yourEmail,
                    onValueChange = { yourEmail = it },
                    label = { Text("Enter Your Email") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier.fillMaxWidth()
                )

                // About Your School section
                SectionTitle(text = "About Your School")
                OutlinedTextField(
                    value = schoolName,
                    onValueChange = { schoolName = it },
                    label = { Text("School Name") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = schoolDistrict,
                    onValueChange = { schoolDistrict = it },
                    label = { Text("School District") },
                    modifier = Modifier.fillMaxWidth()
                )
//                TODO here you have to implement the checkbox code
//                Checkbox(
//                    checked = hasHostedWorkshops,
//                    onCheckedChange = { hasHostedWorkshops = it },
//                    label = { Text("Has your school hosted our Financial Educational Workshops before?") }
//                )

                // About the Workshops section
                SectionTitle(text = "About the Workshops")
                //                TODO here you have to implement the checkbox code

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
                OutlinedTextField(
                    value = workshopGradesAndClasses,
                    onValueChange = { workshopGradesAndClasses = it },
                    label = { Text("Which grades would you like Financial Educational Workshops for and how many classes are in each grade?") },
                    modifier = Modifier.fillMaxWidth()
                )

//                Checkbox(
//                    checked = hasWorkshopForParents,
//                    onCheckedChange = { hasWorkshopForParents = it },
//                    label = { Text("Would you like to have a workshop for parents?") }
//                )
                OutlinedTextField(
                    value = workshopStartDate,
                    onValueChange = { workshopStartDate = it },
                    label = { Text("When would you like these workshops to take place?") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = preferredEducator,
                    onValueChange = { preferredEducator = it },
                    label = { Text("Do you have a preference for which educator on our team visits your school?") },
                    modifier = Modifier.fillMaxWidth()
                )


                // Submit button
                Button(
                    onClick = { /* Handle submit */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    Text(text = "Submit")
                }
            }
        }
    )


}
@Preview
@Composable
fun BookAWorkshopScreenPreview(modifier: Modifier = Modifier) {
    BookAWorkshopScreen()
}

@Composable
fun SectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier
            .padding(top = 16.dp, bottom = 8.dp)
            .fillMaxWidth()
    )
}