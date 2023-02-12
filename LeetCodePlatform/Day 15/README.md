## Task 1(Number of islands)

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]

Output: 1


* Links:

https://leetcode.com/problems/number-of-islands/



import pandas as pd
import numpy as np
import dash
from dash import dcc
from dash import html
from dash.dependencies import Input, Output
import plotly.graph_objs as go
import plotly.express as px
from plotly.subplots import make_subplots
import plotly.graph_objects as go
import matplotlib.pyplot as plt

# ⚡ Total Sales Total Spend between time
demo_data = pd.read_csv("data/Daily_data.csv")

fig1 = make_subplots(specs = [[{"secondary_y": True}]])
fig1.add_trace(go.Scatter(x = demo_data['date'], y = demo_data['current_total_price'], 
                          mode = 'lines', name = 'Daily Sales'), secondary_y = False)          
fig1.add_trace(go.Scatter(x = demo_data['date'], y = demo_data['spend'],
                    mode = 'lines', name = 'Daily Ad Spend'), secondary_y = True)
min_month = pd.to_datetime(demo_data['date']).min().strftime("%b")
max_month = pd.to_datetime(demo_data['date']).max().strftime("%b") 
fig1.update_layout(title = {'text':  f"Total sales and total spend from {min_month} to {max_month}",
                            'y':0.9, 'x':0.5, 'xanchor': 'center', 'yanchor': 'top'},
                   height = 350,
                   plot_bgcolor = '#1f2c56', paper_bgcolor = '#1f2c56', hovermode = 'closest', 
                   titlefont = {'color': 'white', 'size': 20},
                   legend = {'orientation': 'h','bgcolor': '#1f2c56','xanchor': 'center', 'x': 0.8, 'y': -0.17},
                   font = dict(family = "sans-serif", size = 12, color = 'white'))
fig1.update_xaxes(title_text = "Date")
fig1.update_yaxes(title_text = "Total Sales", secondary_y = False)
fig1.update_yaxes(title_text = "Total Spend", secondary_y = True)


# ⚡ Total Sales vc Total Spend
fig2 = px.scatter(demo_data, x = "spend", y = "current_total_price", 
                  trendline = "ols").update_traces(marker = dict(color = 'orange'))
fig2.update_layout(title = {'text':  "Total sales VS total spend",
                            'y':0.9, 'x':0.5, 'xanchor': 'center', 'yanchor': 'top'},
                   height = 350,
                   xaxis_title = "Daily AD Spend", yaxis_title = "Daily Sales",
                   plot_bgcolor = '#1f2c56', paper_bgcolor = '#1f2c56', hovermode = 'closest', 
                   titlefont = {'color': 'white', 'size': 20},
                   font = dict(family = "sans-serif", size = 12, color = 'white'))

# ⚡ Monthly Summary
demo_data['year'] =  pd.to_datetime(demo_data['date']).apply(lambda x: x.strftime("%Y"))
demo_data['month'] = pd.to_datetime(demo_data['date']).apply(lambda x: x.strftime("%b"))
group = demo_data.groupby(['year', 'month'])[['cac', 'roas', 'current_total_price', 'spend']].mean().reset_index()
group['index'] = [i+' '+j for i, j in zip(group['year'], group['month'])]

fig3 = make_subplots(specs = [[{"secondary_y": True}]])
fig3.add_trace(go.Bar(x = group['index'], y = group['cac'], 
                          name = 'Daily Sales'), secondary_y = False)          
fig3.add_trace(go.Bar(x = group['index'], y = group['roas'],
                      name = 'Daily Ad Spend'), secondary_y = False)
fig3.add_trace(go.Scatter(x = group['index'], y = np.log(group['current_total_price']),
                    mode = 'lines', name = 'Daily Ad Spend'), secondary_y = True)
fig3.add_trace(go.Scatter(x = group['index'], y = np.log(group['spend']),
                    mode = 'lines', name = 'Daily Ad Spend'), secondary_y = True)
fig3.update_layout(title = {'text':  f"Monthly Summary",
                            'y':0.9, 'x':0.5, 'xanchor': 'center', 'yanchor': 'top'},
                   height = 350,
                   plot_bgcolor = '#1f2c56', paper_bgcolor = '#1f2c56', hovermode = 'closest', 
                   titlefont = {'color': 'white', 'size': 20},
                   legend = {'orientation': 'h','bgcolor': '#1f2c56','xanchor': 'center', 'x': 0.8, 'y': -0.17},
                   font = dict(family = "sans-serif", size = 12, color = 'white'))
fig3.update_xaxes(title_text = "Date")
fig3.update_yaxes(title_text = "Daily CAC/ROAS", secondary_y = False)
fig3.update_yaxes(title_text = "Daily Sales/AD Spend", secondary_y = True)


# ⚡ Top 10 Frequenly Ordered products

order_data = pd.read_csv("data/order_items.csv")

# Use GroupBy() & compute sum on specific column
data = order_data.groupby('product_name')['quantity'].sum().reset_index()

# converty to df
grouped_data = pd.DataFrame(data=data)

# sort in descending order
grouped_data = grouped_data.sort_values("quantity", ascending=False)

fig4 = make_subplots(specs = [[{"secondary_y": True}]])

# get top 10 products
k = 10

# Prepare for visualization
fig4.add_trace(go.Bar(x = grouped_data['product_name'][:k], y = grouped_data['quantity'][:k], 
                          name = 'Top orders'), secondary_y = False, orientation='h') 

fig4.update_layout(title = {'text':  f"Top 10 frequenty ordered products",
                            'y':0.9, 'x':0.5, 'xanchor': 'center', 'yanchor': 'top'},
                   height = 350,
                   plot_bgcolor = '#1f2c56', paper_bgcolor = '#1f2c56', hovermode = 'closest', 
                   titlefont = {'color': 'white', 'size': 20},
                   legend = {'orientation': 'h','bgcolor': '#1f2c56','xanchor': 'center', 'x': 0.8, 'y': -0.17},
                   font = dict(family = "sans-serif", size = 12, color = 'white'))
fig4.update_xaxes(title_text = "Product Name")
fig4.update_yaxes(title_text = "Quantity Ordered", secondary_y = False)


ad_data = pd.read_csv("data/ad_data.csv")
campaign_dict = {}
for i, campaign_name in enumerate(list(ad_data['campaign_name'].unique())):
    campaign_dict[campaign_name] = f'Campaign_{i}'
    
adset_dict = {}
for i, adset_name in enumerate(list(ad_data['adset_name'].unique())):
    adset_dict[adset_name] = f'Adset_{i}'
              
for i in range(len(ad_data)):
    ad_data.loc[i, 'campaign_name'] = campaign_dict[ad_data.loc[i, 'campaign_name']]
    ad_data.loc[i, 'adset_name'] = adset_dict[ad_data.loc[i, 'adset_name']]
    
# ⚡ Top 10 Customers
df = pd.read_csv('data/Top_Customer.csv')
fig10 = go.Figure(go.Bar(
            y=list(df["Email"]),#.reverse(),
            x=list(df['Life-time Value']),#.reverse(),
            orientation='h'))
fig10.update_layout(title = {'text':  f"Top 10 Customer",
                            'y':0.9, 'x':0.5, 'xanchor': 'center', 'yanchor': 'top'},
                   height = 350,
                   plot_bgcolor = '#1f2c56', paper_bgcolor = '#1f2c56', hovermode = 'closest', 
                   titlefont = {'color': 'white', 'size': 20},
                   legend = {'orientation': 'h','bgcolor': '#1f2c56','xanchor': 'center', 'x': 0.8, 'y': -0.17},
                   font = dict(family = "sans-serif", size = 12, color = 'white'))

# ⚡ Product Selling Status
df = pd.read_csv('data/Product Selling Status.csv')
val_list = []
for col in list(df.columns):
    val_list.append(df[col])
fig11 = go.Figure(data=[go.Table(
    header=dict(values=list(df.columns),
                fill_color='paleturquoise',
                align='left'),
    cells=dict(values=val_list,#[df.Rank, df.State, df.Postal, df.Population],
               fill_color='lavender',
               align='left'))
])
fig11.update_layout(title = {'text':  f"Product Selling Status",
                            'y':0.9, 'x':0.5, 'xanchor': 'center', 'yanchor': 'top'},
                   height = 350,
                   plot_bgcolor = '#1f2c56', paper_bgcolor = '#1f2c56', hovermode = 'closest', 
                   titlefont = {'color': 'white', 'size': 20},
                   legend = {'orientation': 'h','bgcolor': '#1f2c56','xanchor': 'center', 'x': 0.8, 'y': -0.17},
                   font = dict(family = "sans-serif", size = 12, color = 'black'))



app = dash.Dash(__name__, meta_tags = [{"name": "viewport", "content": "width=device-width"}])

app.layout = html.Div([
    # First row
    html.Div([
        html.Div([
            html.Img(src = app.get_asset_url('supercat.png'), id = 'image', 
                     style = {"height": "60px", "width": "auto", "margin-bottom": "25px",},)],
            className = "one-third column",),
        
        html.Div([
            html.Div([html.H2("DashBoard", style = {"margin-bottom": "0px", 'color': 'white'})])], 
            className = "one-half column", id = "title"),
        
        html.Div([
            html.H6("Version: Demo", style = {'color': 'orange'}),], 
            className = "one-third column", id = 'title1'),], 
        
        id = "header", className = "row flex-display", style = {"margin-bottom": "25px"}),
    
    # Second row
    html.Div([
        html.P('Select the group:', className = 'fix_label',  style = {'color': 'white'}),
        dcc.Dropdown(id = 'summary_group', multi = False, clearable = True, value = 'Current', 
                         placeholder = 'Select the group',
                         options = [{'label': c, 'value': c} for c in (['Overall', 'Current'])], 
                         className = 'dcc_compon'),
        html.Div([
            html.Div([
                # html.H6(children = 'Total Sales', style = {'textAlign': 'center','color': 'white'}),
                dcc.Graph(id = 'current_total_price', config = {'displayModeBar': False}, 
                              className = 'dcc_compon',style = {'margin-top': '20px'},)
                ], className = "card_container three columns",),

            html.Div([
                # html.H6(children = 'Cost', style = {'textAlign': 'center', 'color': 'white'}),
                dcc.Graph(id = 'total_cost', config = {'displayModeBar': False}, className = 'dcc_compon',
                              style = {'margin-top': '20px'},)
                ], className = "card_container three columns",),

            html.Div([
                # html.H6(children = 'Tax', style = {'textAlign': 'center', 'color': 'white'}),
                dcc.Graph(id = 'tax', config = {'displayModeBar': False}, className = 'dcc_compon',
                              style = {'margin-top': '20px'},)
                ], className = "card_container three columns",),

            html.Div([
                # html.H6(children = 'Net Profit', style = {'textAlign': 'center', 'color': 'white'}),
                dcc.Graph(id = 'net_profit', config = {'displayModeBar': False}, className = 'dcc_compon',
                              style = {'margin-top': '20px'},)
                ], className = "card_container three columns"),

        ], className = "row flex-display"),
        
        html.Div([
            html.Div([
                # html.H6(children = 'Overall CAC', style = {'textAlign': 'center', 'color': 'white'}),
                dcc.Graph(id = 'cac', config = {'displayModeBar': False}, className = 'dcc_compon',
                          style = {'margin-top': '20px'},)
                ], className = "card_container three columns"),

             html.Div([
                # html.H6(children = 'Overall ROAS', style = {'textAlign': 'center', 'color': 'white'}),
                dcc.Graph(id = 'roas', config = {'displayModeBar': False}, className = 'dcc_compon',
                          style = {'margin-top': '20px'},)
                ], className = "card_container three columns")
        ], className = "row flex-display"),
        
    ], className = "create_container twelve columns",),

    # Third row
    html.Div([
        html.Div([dcc.Graph(figure = fig1, config = {'displayModeBar': 'hover'}),], 
                 className = "create_container seven columns"),
        
         html.Div([dcc.Graph(figure = fig2, config = {'displayModeBar': 'hover'}),], 
                 className = "create_container five columns"),],
        className = "row flex-display"),
    
    # Forth row
    html.Div([
        html.Div([
            html.P('Select the group:', className = 'fix_label',  style = {'color': 'white'}),
            dcc.Dropdown(id = 'w_group', multi = False, clearable = True, value = 'Campaign', 
                         placeholder = 'Select the group',
                         options = [{'label': c, 'value': c} for c in (['Campaign', 'Adset'])], 
                         className = 'dcc_compon'),
            
            dcc.Graph(id = 'group_chart', config = {'displayModeBar': 'hover'}),], 
            className = "create_container six columns", id = "cross-filter-options"),
        html.Div([dcc.Graph(figure = fig3, config = {'displayModeBar': 'hover'}),], 
                 className = "create_container five columns"),
        
        ], className = "row flex-display"),
    # 5th
    html.Div([
        html.Div([dcc.Graph(figure = fig10, config = {'displayModeBar': 'hover'}),], 
                 className = "create_container seven columns"),

    ],

        className = "row flex-display"),
    #6th
    html.Div([
         html.Div([dcc.Graph(figure = fig11, config = {'displayModeBar': 'hover'}),], 
                 className = "create_container twelve columns"),],

        className = "row flex-display"),    
    ], id = "mainContainer", style = {"display": "flex", "flex-direction": "column"})


@app.callback(
    Output('current_total_price', 'figure'),
    Output('total_cost', 'figure'),
    Output('tax', 'figure'),
    Output('net_profit', 'figure'),
    Output('cac', 'figure'),
    Output('roas', 'figure'),
    [Input('summary_group', 'value')])
def update_summary(summary_group):
    if summary_group == None:
        summary_group = 'Current'
        
    demo_data.sort_values(['date'], inplace = True)
    demo_data['year'] =  pd.to_datetime(demo_data['date']).apply(lambda x: x.strftime("%Y"))
    demo_data['month'] = pd.to_datetime(demo_data['date']).apply(lambda x: x.strftime("%b"))
    summary_group = str(summary_group)
    
    if summary_group == 'Overall':
        sales_fig = {
                'data': [go.Indicator(mode = 'number', value = demo_data['current_total_price'].sum(),
                                      number = {'valueformat': 'd', 'font': {'size': 30}, 'prefix': '$'},
                                      domain = {'y': [0, 1], 'x': [0, 1]}, number_font_color = "orange")],
                'layout': go.Layout(
                    title = {'text': 'Total Sales', 'y': 1, 'x': 0.5, 'xanchor': 'center', 'yanchor': 'top'},
                    font = dict(color = 'white'), paper_bgcolor = '#1f2c56', plot_bgcolor = '#1f2c56',
                    height = 50),}
        spend_fig = {
                'data': [go.Indicator(mode = 'number', value = demo_data['spend'].sum(), 
                                      number = {'valueformat': 'd', 'font': {'size': 30}, 'prefix': '$'},
                                      domain = {'y': [0, 1], 'x': [0, 1]}, number_font_color = "orange")],
                'layout': go.Layout(
                    title = {'text': 'Total Cost', 'y': 1, 'x': 0.5, 'xanchor': 'center', 'yanchor': 'top'},
                    font = dict(color = 'white'), paper_bgcolor = '#1f2c56', plot_bgcolor = '#1f2c56',
                    height = 50),}
        tax_fig = {
                'data': [go.Indicator(mode = 'number', value = 0, 
                                      number = {'valueformat': 'd', 'font': {'size': 30}, 'prefix': '$'},
                                      domain = {'y': [0, 1], 'x': [0, 1]}, number_font_color = "orange")],
                'layout': go.Layout(
                    title = {'text': 'Total Tax', 'y': 1, 'x': 0.5, 'xanchor': 'center', 'yanchor': 'top'},
                    font = dict(color = 'white'), paper_bgcolor = '#1f2c56', plot_bgcolor = '#1f2c56',
                    height = 50),}
        net_profit_fig = {
                'data': [go.Indicator(mode = 'number', value = 8436.82, 
                                      number = {'valueformat': 'd', 'font': {'size': 30}, 'prefix': '$'},
                                      domain = {'y': [0, 1], 'x': [0, 1]}, number_font_color = "orange")],
                'layout': go.Layout(
                    title = {'text': 'Net Profit', 'y': 1, 'x': 0.5, 'xanchor': 'center', 'yanchor': 'top'},
                    font = dict(color = 'white'), paper_bgcolor = '#1f2c56', plot_bgcolor = '#1f2c56',
                    height = 50),}
        cac_fig = {
                'data': [go.Indicator(mode = 'number', value = demo_data['cac'].sum(), 
                                      number = {'valueformat': '.2f', 'font': {'size': 30}, 'prefix': '$'},
                                      domain = {'y': [0, 1], 'x': [0, 1]}, number_font_color = "orange")],
                'layout': go.Layout(
                    title = {'text': 'CAC', 'y': 1, 'x': 0.5, 'xanchor': 'center', 'yanchor': 'top'},
                    font = dict(color = 'white'), paper_bgcolor = '#1f2c56', plot_bgcolor = '#1f2c56',
                    height = 50),}
        roas_fig = {
                'data': [go.Indicator(mode = 'number', value = demo_data['roas'].sum(), 
                                      number = {'valueformat': '.2f', 'font': {'size': 30}, 'prefix': '$'},
                                      domain = {'y': [0, 1], 'x': [0, 1]}, number_font_color = "orange")],
                'layout': go.Layout(
                    title = {'text': 'ROAS', 'y': 1, 'x': 0.5, 'xanchor': 'center', 'yanchor': 'top'},
                    font = dict(color = 'white'), paper_bgcolor = '#1f2c56', plot_bgcolor = '#1f2c56',
                    height = 50),}
        
        return sales_fig, spend_fig, tax_fig, net_profit_fig, cac_fig, roas_fig
    
    elif summary_group == 'Current':
        group = demo_data.groupby(['year', 'month'])
        group = group[['current_total_price', 'spend', 'cac', 'roas']].sum().reset_index()

        sales_fig = {
                'data': [go.Indicator(
                        mode = 'number+delta', value = group['current_total_price'].iloc[-1],
                        delta = {'reference': group['current_total_price'].iloc[-2], 'position': 'right', 
                                 'valueformat': '.2f','relative': True, 'font': {'size': 20}},
                        number = {'font': {'size': 30}, 'valueformat': 'd', 'prefix': '$'}, 
                        domain = {'y': [0, 1], 'x': [0, 1]}, number_font_color = "orange")],
                'layout': go.Layout(
                    title = {'text': 'Total Sales', 'y': 1, 'x': 0.5, 'xanchor': 'center', 'yanchor': 'top'},
                    margin = dict(l=0, r=0, t=0, b=0),
                    font = dict(color = 'white'), paper_bgcolor = '#1f2c56', plot_bgcolor = '#1f2c56',
                    height = 50),}
        spend_fig = {
                'data': [go.Indicator(
                        mode = 'number+delta', value = group['spend'].iloc[-1],
                        delta = {'reference': group['spend'].iloc[-2], 'position': 'right', 
                                 'valueformat': '.2f','relative': True, 'font': {'size': 20}},
                        number = {'font': {'size': 30}, 'valueformat': 'd', 'prefix': '$'}, 
                        domain = {'y': [0, 1], 'x': [0, 1]}, number_font_color = "orange")],
                'layout': go.Layout(
                    title = {'text': 'Total Sales', 'y': 1, 'x': 0.5, 'xanchor': 'center', 'yanchor': 'top'},
                    margin = dict(l=0, r=0, t=0, b=0),
                    font = dict(color = 'white'), paper_bgcolor = '#1f2c56', plot_bgcolor = '#1f2c56',
                    height = 50),}
        tax_fig = {
                'data': [go.Indicator(
                        mode = 'number+delta', value = 1234,
                        delta = {'reference': 1000, 'position': 'right', 
                                 'valueformat': '.2f','relative': True, 'font': {'size': 20}},
                        number = {'font': {'size': 30}, 'valueformat': 'd', 'prefix': '$'}, 
                        domain = {'y': [0, 1], 'x': [0, 1]}, number_font_color = "orange")],
                'layout': go.Layout(
                    title = {'text': 'Tax', 'y': 1, 'x': 0.5, 'xanchor': 'center', 'yanchor': 'top'},
                    margin = dict(l=0, r=0, t=0, b=0),
                    font = dict(color = 'white'), paper_bgcolor = '#1f2c56', plot_bgcolor = '#1f2c56',
                    height = 50),}
        net_profit_fig = {
                'data': [go.Indicator(
                        mode = 'number+delta', value = 5678,
                        delta = {'reference': 678, 'position': 'right', 
                                 'valueformat': '.2f','relative': True, 'font': {'size': 20}},
                        number = {'font': {'size': 30}, 'valueformat': 'd', 'prefix': '$'}, 
                        domain = {'y': [0, 1], 'x': [0, 1]}, number_font_color = "orange")],
                'layout': go.Layout(
                    title = {'text': 'Net profit', 'y': 1, 'x': 0.5, 'xanchor': 'center', 'yanchor': 'top'},
                    margin = dict(l=0, r=0, t=0, b=0),
                    font = dict(color = 'white'), paper_bgcolor = '#1f2c56', plot_bgcolor = '#1f2c56',
                    height = 50),}
        cac_fig = {
                'data': [go.Indicator(
                        mode = 'number+delta', value = group['cac'].iloc[-1],
                        delta = {'reference': group['cac'].iloc[-2], 'position': 'right', 
                                 'valueformat': '.2f','relative': True, 'font': {'size': 20}},
                        number = {'font': {'size': 30}, 'valueformat': '.2f', 'prefix': '$'}, 
                        domain = {'y': [0, 1], 'x': [0, 1]}, number_font_color = "orange")],
                'layout': go.Layout(
                    title = {'text': 'CAC', 'y': 1, 'x': 0.5, 'xanchor': 'center', 'yanchor': 'top'},
                    margin = dict(l=0, r=0, t=0, b=0),
                    font = dict(color = 'white'), paper_bgcolor = '#1f2c56', plot_bgcolor = '#1f2c56',
                    height = 50),}
        roas_fig = {
                'data': [go.Indicator(
                        mode = 'number+delta', value = group['roas'].iloc[-1],
                        delta = {'reference': group['roas'].iloc[-2], 'position': 'right', 
                                 'valueformat': '.2f','relative': True, 'font': {'size': 20}},
                        number = {'font': {'size': 30}, 'valueformat': '.2f', 'prefix': '$'}, 
                        domain = {'y': [0, 1], 'x': [0, 1]}, number_font_color = "orange")],
                'layout': go.Layout(
                    title = {'text': 'ROAS', 'y': 1, 'x': 0.5, 'xanchor': 'center', 'yanchor': 'top'},
                    margin = dict(l=0, r=0, t=0, b=0),
                    font = dict(color = 'white'), paper_bgcolor = '#1f2c56', plot_bgcolor = '#1f2c56',
                    height = 50),}

        return sales_fig, spend_fig, tax_fig, net_profit_fig, cac_fig, roas_fig
    
@app.callback(Output('group_chart', 'figure'),
              [Input('w_group', 'value')])

def update_graph(w_group):
    abailable_group = {"Campaign": "campaign_name", "Adset": "adset_name"}
    if w_group == None:
        w_group = "Campaign"
    column = str(w_group)
    column = abailable_group[column]
    group = ad_data.groupby([column]).mean()
    group.columns = group.columns + '_avg'
    group.reset_index(drop = False, inplace = True)    
    group.sort_values(['roas_avg'], ascending = False, inplace = True)
    
    fig = make_subplots(specs = [[{"secondary_y" : True}]])
    fig.add_trace(go.Bar(x = group[column], y = group['roas_avg'], name = 'ROAS'), secondary_y = False)
    fig.add_trace(go.Scatter(x = group[column], y = group['cpc_avg'], name = 'CPC', mode = 'lines'),
                  secondary_y = True)
    fig.add_trace(go.Scatter(x = group[column], y = group['cpa_avg'], name = 'CPA', mode = 'lines'),
                  secondary_y = True)
    fig.add_trace(go.Scatter(x = group[column], y = group['cpm_avg'], name = 'CPM', mode = 'lines'),
                  secondary_y = True)
    
    fig.update_layout(
            plot_bgcolor = '#1f2c56',
            paper_bgcolor = '#1f2c56',
            hovermode = 'closest',
            title = {'text': 'Summary of each ' + (w_group), 'y': 0.93, 'x': 0.5, 'xanchor': 'center',
                   'yanchor': 'top'},
            height = 350,
            titlefont = {'color': 'white', 'size': 20},
            legend = {'bgcolor': '#1f2c56', 'xanchor': 'center', 'x': 1.3, 'y': 1},
            font = dict(family = "sans-serif", size = 12, color = 'white'))
    
    fig.update_yaxes(title_text = "Average ROAS", secondary_y = False)
    fig.update_yaxes(title_text = "Average CPC/CPA/CPM ", secondary_y = True)
                      
    return fig 

if __name__ == '__main__':
    app.run_server(host = '0.0.0.0', port = 55555, debug = True)