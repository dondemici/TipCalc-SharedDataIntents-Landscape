Tip Calculator App
Overview
This is a simple Tip Calculator Android app that calculates the monthly payment (bill amount + tip) based on a user's input. It allows the user to adjust the tip percentage and view the total bill and the tip amount. After entering the total bill, the app will show the calculated tip and total payment. The user can increase or decrease the tip percentage, and the changes will immediately reflect in the UI. Additionally, the app includes functionality to display the result in both portrait and landscape orientations.

Features
Adjust Tip Percentage: Users can increase or decrease the tip percentage using buttons.

Total Bill Input: Users can input their total bill amount.

Tip Calculation: The app calculates the tip based on the current bill and tip percentage.

Result Display: Displays the total bill, tip amount, and final payment.

Shared Data with Intents: The calculated monthly payment and the user's name are passed to the SecondActivity using Intents.

Portrait and Landscape Support: The app is designed to support both portrait and landscape orientations. A landscape-specific layout has been implemented.

Screenshots
(You can add a screenshot here of your app for a more user-friendly README)

Functionality
1. Main Activity:
EditText for Total Bill: Allows users to enter the bill amount.

TextViews for Tip Percentage and Tip Amount: Shows the current tip percentage and the calculated tip.

Buttons to Adjust Tip: Increases or decreases the tip percentage by 1%.

Submit Button: Calculates the total payment (bill + tip) and passes it to the SecondActivity.

2. Second Activity (Shared Data with Intents):
The SecondActivity receives the name and calculated monthly payment (bill + tip) from the MainActivity using Intents.

Shared Data: The app passes data from MainActivity to SecondActivity using Intent.putExtra().

Result Display: Displays the total payment (monthly payment) along with the user's name passed from MainActivity.

3. Landscape Layout:
Landscape Orientation Support: A landscape-specific layout has been added to handle the app's UI in landscape mode. The landscape layout is placed in the res/layout-land/ directory. It mirrors the layout in portrait mode but is adjusted for horizontal screen real estate.

How It Works: By adding a layout in the layout-land directory, Android automatically switches to this layout when the device is rotated into landscape mode. This allows you to customize how the app looks in both orientations.
