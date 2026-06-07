@echo off
:: ===================================================
:: Run AIMS GUI Application
:: ===================================================
set FXLIB=D:\oop lab\javafx-sdk\lib
set CP=D:\oop lab\202417020_b-i-c-ng-s-n-oop\AimsProject\bin
set FX_MODS=javafx.controls,javafx.fxml,javafx.swing,javafx.graphics,javafx.base

echo Starting AIMS Application...
java --module-path "%FXLIB%" --add-modules %FX_MODS% -cp "%CP%" hust.soict.dsai.aims.Aims
pause
