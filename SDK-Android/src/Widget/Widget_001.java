/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;

//20160830 - SmartAdserver-JA: Agregamos referencia a SDK-SmartAdserver
import com.smartadserver.android.library.SASBannerView;

/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in {@link SimpleWidgetConfigureActivity SimpleWidgetConfigureActivity}
 */
public class SimpleWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        //Codigo propio del Widget - INI
        CharSequence widgetText = SimpleWidgetConfigureActivity.loadTitlePref(context, appWidgetId);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.simple_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);
        //Codigo propio del widget - FIN

        //20160830 - SmartAdserver-JA: Implementación SMART BANNER - INI
        SASBannerView mBannerView = new SASBannerView(context);
        // Get density pixel height of 50
        int dpHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, context.getResources().getDisplayMetrics());
        // Set layout parameters, get layout in which you want to add your banner and add it
        mBannerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, dpHeight));
        /*20160830 - SmartAdserver-JA: En la siguiente linea determinamos que no es posible 
                                       usar directamente los componente de Smart en un Widget*/
        views.addView(R.id.appwidget_text, mBannerView);
        //20160830 - SmartAdserver-JA: Implementación SMART BANNER - FIN

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    //Codigo propio de Widget - INI
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // When the user deletes the widget, delete the preference associated with it.
        for (int appWidgetId : appWidgetIds) {
            SimpleWidgetConfigureActivity.deleteTitlePref(context, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
    //Codigo propio de Widget - FIN
}
