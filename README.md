# Notification Composable

![Screenshot from 2024-06-03 20-44-47](https://github.com/Siddhesh2377/Notification/assets/67579112/cdcc7b28-a075-4b10-b7a5-f39741fc845f)


## Description
This is a Kotlin Jetpack Compose function to display notifications in your Android app. It creates a floating window with a customizable message and a close button.

## Usage
To use this Composable in your Android project, follow these steps:

1. Copy the `Notification` function into your project.
2. Call the `Notification` function where you want to display a notification, passing the text message and a callback function to handle closing the notification.
3. Customize the appearance and behavior of the notification window by modifying the parameters of the `Window` function.

## Example
```kotlin
// Display a simple notification
Notification(text = "Hello, world!") {
    // Define the action to take when the notification is closed
    // For example, you could update a state variable to hide the notification
    // or perform any other necessary cleanup.
    // e.g., isVisible.value = false
}

// Customize the notification window
Notification(
    text = "Custom Notification",
    onClose = {
        // Define the action to take when the notification is closed
    },
    // Customize window properties
    // For example, you can change the width, height, position, or appearance of the notification window.
    windowProperties = WindowProperties(
        width = 400.dp,
        height = 100.dp,
        placement = WindowPlacement.Floating,
        position = WindowPosition(Alignment.TopEnd),
        isResizable = false,
        isUndecorated = true,
        isTransparent = true
    )
)
