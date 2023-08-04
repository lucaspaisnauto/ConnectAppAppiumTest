# ConnectAppAppiumTest

### This repo will hold a sample test for our ConnectApp (Android), and provide the steps to install and configure Appium on Linux (Ubuntu)

# Getting Started

In order to run this test on Android emulator, please follow the next steps:
1. Install Android Studio
2. Install JAVA
3. Create ENV variables and add to PATH
5. Install Homebrew
5. Install node + npm
6. Install appium & appium-doctor
7. Install appium UiAutomator2 driver
8. Run appium
9. Clone project & Run tests

## 1. Install Android Studio

#### There are several ways you can perform this:

1. Snap repository
```
$ sudo apt update 
$ sudo apt install snapd 
$ sudo snap install android-studio –classic 
```
or

2. Install from Ubuntu Software
[Ubuntu Software](https://github.com/lucaspaisnauto/ConnectAppAppiumTest/assets/113471492/4bdac273-211e-4ace-9554-ebc5cbfcdf73)

or

3. Go to [https://developer.android.com/studio](https://developer.android.com/studio) and download it from there


## 2. Install JAVA
```
$ sudo add-apt-repository -y ppa:webupd8team/java
$ sudo apt-get update
$ sudo apt install openjdk-11-jdk
```

## 3. Create EVN variables and add to PATH
#### On this step, is better to add the following lines to bashrc, so we don't have to run the commands everytime we open a terminal.

```
$ sudo nano ~/.bashrc
```
add the lines at the end of the file:
```
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64/
export PATH=$PATH:$JAVA_HOME/bin

export ANDROID_HOME=Android/Sdk/
export PATH=$PATH:$ANDROID_HOME/tools
```
 
 As expected, the commands will depend on your instalation folders.


 ## 4. Install Homebrew

 Update repositories in UBUNTU

 ```
 $ sudo apt update
 $ sudo apt-get install build-essential
 ```

if GIT is not installed:

```
$ sudo apt install git -y
```

Run Homebrew installation script

```
$ /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

```

Add Homebrew to PATH

```
$ (echo; echo 'eval "$(/home/linuxbrew/.linuxbrew/bin/brew shellenv)"') >> /home/$USER/.bashrc

$ eval "$(/home/linuxbrew/.linuxbrew/bin/brew shellenv)"
```

Check Brew is working fine
```
$ brew doctor

Your system is ready to brew.
```
(ONLY If a warning is present regarding GCC libs)
```
$ brew install gcc
```


## 5. Install node + npm (Install with Homebrew for better results)

```
$ brew install node
```

## 6. Install appium & appium doctor (install with node that comes from Homebrew for better results)

```
$ npm install appium-doctor
$ npm install -g appium
$ appium-doctor

✔ ANDROID_HOME is set to "Android/Sdk/"
✔ JAVA_HOME is set to "/usr/lib/jvm/java-11-openjdk-amd64/."
✔ ADB exists at /home/lucas/Android/Sdk/platform-tools/adb
✔ Android exists at /home/lucas/Android/Sdk/tools/android
✔ Emulator exists at /home/lucas/Android/Sdk/tools/emulator
✔ Android Checks were successful.

✔ All Checks were successful
```

## 7. Install appium UiAutomator2 driver

```
appium driver install uiautomator2
```

## 8. Run appium

```
appium server --address localhost --port 4723 --use-drivers uiautomator2 --base-path /wd/hub
```

## 9. Clone project & Run tests

```
$ git clone https://github.com/lucaspaisnauto/ConnectAppAppiumTest.git
```