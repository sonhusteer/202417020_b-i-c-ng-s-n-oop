@echo off
:: ===================================================
:: Run JavaFX Painter App
:: ===================================================
set FXLIB=D:\oop lab\javafx-sdk\lib
set CP=D:\oop lab\202417020_b-i-c-ng-s-n-oop\GUIProject\bin;%FXLIB%\javafx.fxml.jar;%FXLIB%\javafx.controls.jar;%FXLIB%\javafx.graphics.jar;%FXLIB%\javafx.base.jar
set FX_MODS=javafx.controls,javafx.fxml,javafx.graphics,javafx.base

echo Starting Painter Application...
java --module-path "%FXLIB%" --add-modules %FX_MODS% -cp "%FXLIB%\javafx.base.jar;%FXLIB%\javafx.controls.jar;%FXLIB%\javafx.fxml.jar;%FXLIB%\javafx.graphics.jar;D:\oop lab\202417020_b-i-c-ng-s-n-oop\GUIProject\bin" hust.soict.dsai.javafx.Painter
pause
