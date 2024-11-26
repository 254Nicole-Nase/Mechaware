# Mechaware - Car Parts and Accessories Marketplace

Mechaware is a marketplace app designed to allow car owners, mechanics, and businesses to buy and sell automotive parts and accessories. The app offers a range of features like product search, secure payment options, seller-buyer messaging, product details, and user feedback. It also includes product upload functionality and community forums for automotive discussions.

---

## Features

- **User Authentication**: Secure login and registration process.
- **Product Search**: Search for car parts and accessories by keywords.
- **Upload Products**: Users can upload products for sale with descriptions and images.
- **Product Details**: View detailed information about the products including images, price, and description.
- **Feedback**: Provide feedback or report issues with the app.
- **Community Forums**: Discuss automotive topics with other users.

---

## Screenshots

Below are some screenshots of the key pages in the app:

| SCREEN SPLASH                  | SCREEN LOGIN           | SCREEN REGISTER           | SCREEN HOME           | PRODUCT DETAILS         | SEARCH SCREEN           | SCREEN CART           | SCREEN UPLOAD           | SCREEN PROFILE           |
|--------------------------------|------------------------|---------------------------|-----------------------|-------------------------|-------------------------|-----------------------|-------------------------|--------------------------|
| ![](/screen/splash_screen.jpg) | ![](/screen/login.jpg) | ![](/screen/register.jpg) | ![](/screen/home.jpg) | ![](/screen/detail.jpg) | ![](/screen/search.jpg) | ![](/screen/cart.jpg) | ![](/screen/upload.jpg) | ![](/screen/profile.jpg) |


---

## Setup and Installation

Follow the steps below to set up and run the Mechaware app:

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/mechaware.git
cd mechaware
```
### 2. Open the Project in Android Studio

1. Open **Android Studio**.
2. Select **Open an existing project**.
3. Navigate to the `mechaware` folder that you cloned from the repository.
4. Click **OK** to open the project in Android Studio.

### 3. Sync Gradle

1. Once the project is open, Android Studio may prompt you to **sync Gradle**. If not, open the `build.gradle` files (both the project-level and app-level).
2. Click on the **Sync Now** link in the notification bar to sync the project dependencies and ensure everything is set up correctly.

### 4. Run the App

1. **Connect your Android device** via USB or use an Android emulator.
2. In Android Studio, select your connected device or the emulator from the device list.
3. Click the **Run** button (green play icon) to build and launch the app on your device.
4. Wait for the app to install and open on your device. You can now test the functionality of the app.

### 5. (Optional) Add Firebase Configuration

1. Go to the [Firebase Console](https://console.firebase.google.com/) and create a new project.
2. Add your Android app to the Firebase project and download the `google-services.json` configuration file.
3. Place the `google-services.json` file in the `app/` directory of your Android project.
4. Add Firebase dependencies to your `build.gradle` files:
   
   In the `project-level build.gradle` file:
   ```gradle
   buildscript {
       repositories {
           google()
           mavenCentral()
       }
       dependencies {
           classpath 'com.google.gms:google-services:4.3.15' // Add this line
       }
   }
   ```
   In the app-level build.gradle file:
   ```gradle
   apply plugin: 'com.google.gms.google-services' // Add this line
   dependencies {
    implementation 'com.google.firebase:firebase-auth:21.1.0'  // Firebase Auth dependency
    implementation 'com.google.firebase:firebase-firestore:24.1.0' // Firebase Firestore dependency
   }
   ```
5. **Sync your Gradle files** to apply these changes. This will enable Firebase services for authentication and Firestore integration.
6. Once Firebase is successfully integrated, you can proceed to implement Firebase Authentication for secure user login and registration, and Firebase Firestore for storing product and user data.

---

## Usage Instructions

### User Authentication

1. Launch the app on your device.
2. On the **Login Screen**, enter your registered email and password to log in.
3. For **new users**, navigate to the **Register Screen** and fill in the necessary details to create an account.
4. After logging in, you will be taken to the home screen, where you can explore products.

### Searching for Products

1. From the **Bottom Navigation Bar**, select the **Search** tab to navigate to the search screen.
2. Enter a product name or keywords in the search bar to filter through available car parts and accessories.
3. The search results will dynamically update as you type.

### Uploading Products

1. To upload a product, go to the **Upload Product Screen** by selecting the **Upload** tab from the Bottom Navigation Bar.
2. Fill in the required fields such as:
   - **Product Name**
   - **Description**
   - **Price**
   - **Category**
3. Upload an image of the product by tapping on the **Upload Image** button.
4. After filling in all the details, click **Submit** to add the product to the marketplace.
   
   This will make the product available for others to view and purchase.

### Viewing Product Details

1. On the **Home Screen** or **Search Screen**, tap on any product to view its detailed information.
2. The **Product Details Screen** includes:
   - **Product Name**
   - **Product Description**
   - **Price**
   - **Seller Information**
3. If you are interested in purchasing, click the **Add to Cart** button to add the item to your cart for later checkout.

### Providing Feedback

1. To provide feedback, select the **Feedback** tab from the Bottom Navigation Bar.
2. Choose the type of feedback (e.g., **Bug Report**, **Feature Suggestion**, etc.).
3. Enter your feedback message and submit it to the development team for review.

---

## Future Enhancements

### Firebase Integration

- **Authentication**: Implement Firebase Authentication for easy, secure login and user registration.
- **Firestore**: Use Firebase Firestore to store products and user data. This allows for dynamic updates and real-time interactions within the app.

### Payment Gateway Integration

- Integrate a **payment gateway** like **Stripe** or **PayPal** to allow users to make secure payments for products directly through the app.
- The payment system will be connected to the product cart and checkout system.

### Dynamic Product Data

- Currently, products are displayed statically. In the future, replace the static product data with API or Firestore-based data to allow for real-time updates, new product listings, and availability checks.

### Push Notifications

- Implement **push notifications** using **Firebase Cloud Messaging (FCM)**. This feature will notify users about new products, special promotions, and order updates.
- **Order Updates**: Notify users when their order status changes (e.g., shipped, delivered).
- **New Messages**: Alert users when they receive messages related to their uploaded products or their cart.

### Community Forums

- Build a **community forum** within the app where users can ask questions, discuss products, and share experiences related to car maintenance, parts, and accessories.
- Implement discussion boards where users can post queries, suggestions, and feedback.

---

## License

This project is licensed under the **MIT License**. See the LICENSE file for more details.

Feel free to contribute to the project, suggest new features, or report any issues. You can contribute by opening **issues** or submitting **pull requests** via the [GitHub repository](https://github.com/your-username/mechaware).

---

## Acknowledgments

- **Jetpack Compose**: For building a modern, declarative UI with Kotlin.
- **Firebase**: For providing backend services like Authentication and Firestore.
- **Android Developers**: For developing the Android tools and resources used to build the app.
- **Open-source Libraries**: Thank you to the open-source community for the libraries and frameworks that enhanced the app's functionality.

---   
